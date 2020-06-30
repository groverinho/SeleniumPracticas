package org.titanium.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test start: "+result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("test passed: "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("test failed: "+result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("test skipped: "+result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    public void onStart(ITestContext context) {
        System.out.println("Start execution (test): "+context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("End of execution (test): "+context.getName());
    }
}
