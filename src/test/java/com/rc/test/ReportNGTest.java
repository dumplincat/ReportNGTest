package com.rc.test;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;

public class ReportNGTest {
    private int index = 0;
//    @BeforeSuite
//    public void beforeSuite(ITestContext context) {
//        for (ITestNGMethod method : context.getAllTestMethods()) {
//            method.setRetryAnalyzer(new RetryAnalyzerImpl());
//        }
//    }
    @BeforeMethod
    public void before(Method method) throws TimeoutException {
        System.out.println("before");
        index++;
        if (index == 3 || index == 6) {
            throw new TimeoutException("Deliberate failure 2" + method.getName());
        }
    }

    @AfterMethod
    public void after(Method method) throws TimeoutException {
        System.out.println("after");
        if (index == 5)
            throw new TimeoutException("Deliberate failure 3" + method.getName());
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() throws TimeoutException {
        System.out.println("test2");
        throw new TimeoutException("Deliberate failure 1");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @Test
    public void test4() {
        System.out.println("test4");
    }

    @Test
    public void test5() {
        System.out.println("test5");
    }

    @Test
    public void test6() {
        System.out.println("test6");
    }

    @Test
    public void test7() {
        System.out.println("test7");
    }
}
