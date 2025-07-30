package extentReporter;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFleakyTests implements IRetryAnalyzer {
	
	int maxTry = 2;
	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (count<2) {
			count++;
			return true;
		}
		return false;
	}
}
