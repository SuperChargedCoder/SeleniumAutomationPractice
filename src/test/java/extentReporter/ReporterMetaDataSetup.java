package extentReporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import expandTestingSeleniumPractice.BaseTest;

public class ReporterMetaDataSetup extends BaseTest {
	
	public static ExtentReports getExtentReports() {
		String reportPath = System.getProperty("user.dir") + "\\ExtentReport\\AutomationReport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("TestAutomationReport");
		reporter.config().setReportName("ExpandTesting.com Automation Test Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Shubham Chaurasia");
		
		return extent;
	}
	
}
