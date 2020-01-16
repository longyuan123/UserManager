package com.yywang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTestNG {

  

    @Test
    public void testCase1() {
        System.out.println("Test - This is testCase1 with @Test");
    }

    @Test
    public void testCase2() {
        System.out.println("Test - This is testCase2 with @Test");
    }
    
    @Test(enabled = false)
    public void ignoreTest() {
        System.out.println("ignoreTest - This testcase will be ignored");
    }
    
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("This is a failed exception test");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess() {
        System.out.println("This is a success exception test");
        throw new RuntimeException();
    }
    
    @Test
    public void dependedTestCase() {
        System.out.println("This is depended TestCase");
    }
   
    @Test(dependsOnMethods = {"dependedTestCase"})
    public void dependTestCase() {
        System.out.println("This is depend TestCase");
    }

   
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod - Run before testcase method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod - Run after testcase method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass - Run before class running");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass -  Run after class running");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite -  Run after class running");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite -  Run after class running");
    }
}
