package extentReporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends ReporterMetaDataSetup implements ITestListener {
	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> extentTest;
	
	@Override
    public void onStart(ITestContext context) {
		extent = ReporterMetaDataSetup.getExtentReports();
		extentTest = new ThreadLocal<ExtentTest>();
    }
	
	
    @Override
    public void onTestStart(ITestResult result) {
    	test = extent.createTest(result.getMethod().getMethodName());
    	extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	extentTest.get().log(Status.PASS, "Test Pass");
    	addScreenShotInReport(result);
    }
    
    
    public void addScreenShotInReport(ITestResult result) {
    	try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String path = null;
    	try {
			path = TakeScreenshot(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	extentTest.get().log(Status.FAIL, result.getThrowable());
    	addScreenShotInReport(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
    }
	
}
