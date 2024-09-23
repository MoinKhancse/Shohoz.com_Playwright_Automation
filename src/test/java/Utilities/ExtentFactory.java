package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {
	public static final ExtentReports extentReport = new ExtentReports();
	
	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/report.html");
		reporter.config().setReportName("Automation By Moin Khan");
		extentReport.attachReporter(reporter);
		return extentReport;
	}

}
