package com.buyProcessE2E;

import AbstractComponents.TestReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentTest test;
    TestReports reports = new TestReports();
    ExtentReports extent;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
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
}
