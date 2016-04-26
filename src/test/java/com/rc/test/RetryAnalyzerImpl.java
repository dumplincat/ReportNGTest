package com.rc.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by shawn.zhang on 4/25/16.
 */
public class RetryAnalyzerImpl implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount < maxRetryCount)
        {
            retryCount++;
            return true;
        }
        return false;
    }
}
