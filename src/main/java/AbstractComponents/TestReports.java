package AbstractComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class TestReports {

    private ExtentSparkReporter reporter;
    private ExtentReports extent;

    public ExtentReports getExtentReports() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReports" + File.separator + "extentReport.html";

            // Create directory if it doesn't exist
            new File(path).getParentFile().mkdirs();

            this.reporter = new ExtentSparkReporter(path);
            this.extent = new ExtentReports();

            this.reporter.config().setReportName("Test Automation Results");
            this.reporter.config().setDocumentTitle("Test Results");
            this.extent.attachReporter(this.reporter);
            this.extent.setSystemInfo("Tester", "Manish");
        }
        return extent;
    }

    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

