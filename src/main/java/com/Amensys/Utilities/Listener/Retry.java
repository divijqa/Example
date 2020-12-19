package com.Amensys.Utilities.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxtry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if (count < maxtry){
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            }else {
                iTestResult.setStatus(ITestResult.SUCCESS);
            }
        }
        return false;
    }
}
