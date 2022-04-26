package com.globant.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.apache.log4j.Logger;

public class Listener implements ITestListener {

    private Logger log = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("THE TEST HAS STARTED");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("THE TEST HAS PASSED");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("THE TEST HAS FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
