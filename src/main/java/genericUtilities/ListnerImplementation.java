package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This class provides implementations to ITestListener Interface Of TestNG
 * 
 */

public class ListnerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//@Test- method
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ====Test Execution Started====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ====Test Execution Pass====");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ====Test Execution Fail====");
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ====Test Execution Skip====");
		System.out.println(result.getThrowable());

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("====Suit execution started=====");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("====Suit execution ended=====");

		
	}
	

}ccc
