package Listeners1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("****** Test Started*******"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("****** Test Successful*******"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("****** Test Failed*******"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("****** Test Skipped*******"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("****** Test failed with timeout*******"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("****** Test Completed*******"+context.getName());
	}

	
}
