package com.buyProcessE2E;

import AbstractComponents.LaunchApp;
import AbstractComponents.TestReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Listeners implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(Listeners.class.getName());

    ExtentTest test;
    TestReports reports = new TestReports();
    ExtentReports extent;
    LaunchApp utility = new LaunchApp();
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        // Ensure extent is initialized before creating a test
        if (extent == null) {
            extent = reports.getExtentReports();
        }
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (test != null) {
            test.log(Status.PASS, "Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (test != null) {
            test.fail(result.getThrowable());
        }

        // Extract driver from test instance using reflection
        driver = extractDriverFromTestInstance(result);

        // Capture and attach screenshot if driver is available
        if (driver != null) {
            attachScreenshot(result);
        } else {
            LOGGER.log(Level.WARNING, "Driver is null; unable to capture screenshot for test: {0}", result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // ...existing code...
    }

    @Override
    public void onStart(ITestContext context) {
        extent = reports.getExtentReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flushReport();
    }

    /**
     * Extracts the WebDriver instance from the test class using reflection.
     * Returns null if extraction fails or driver is not available.
     */
    private WebDriver extractDriverFromTestInstance(ITestResult result) {
        try {
            Object testInstance = result.getInstance();
            if (testInstance == null) {
                LOGGER.log(Level.WARNING, "Test instance is null");
                return null;
            }

            Class<?> testClass = result.getTestClass().getRealClass();
            java.lang.reflect.Field driverField = testClass.getDeclaredField("driver");
            driverField.setAccessible(true);
            Object driverObj = driverField.get(testInstance);

            if (driverObj instanceof WebDriver) {
                return (WebDriver) driverObj;
            } else {
                LOGGER.log(Level.WARNING, "Driver field is not a WebDriver instance or is null");
                return null;
            }
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, "Driver field not found in test class: {0}", e.getMessage());
            return null;
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, "Unable to access driver field: {0}", e.getMessage());
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error while extracting driver: {0}", e.getMessage());
            return null;
        }
    }

    /**
     * Captures screenshot and attaches it to the Extent report.
     */
    private void attachScreenshot(ITestResult result) {
        try {
            String screenshotPath = utility.getScreenshot(result.getMethod().getMethodName(), driver);
            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                if (test != null) {
                    test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
                    LOGGER.log(Level.INFO, "Screenshot attached: {0}", screenshotPath);
                }
            } else {
                LOGGER.log(Level.WARNING, "Screenshot path is empty or null");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed to capture or attach screenshot: {0}", e.getMessage());
        }
    }
}
