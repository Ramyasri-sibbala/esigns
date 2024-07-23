package Pages;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=1;
	int maxretry=2;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<maxretry) {
			counter++;
		return true;
	}
		return false;
		
	}

}
