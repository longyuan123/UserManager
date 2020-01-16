package com.yywang;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class MySecondTestNG {
   
    @Test(groups = "server")
    public void testCase1() {
        System.out.println("This is testCase1 with @Test");
    }

    @Test(groups = "server")
    public void testCase2() {
        System.out.println("This is testCase2 with @Test");
    }

    @Test(groups = "client")
    public void testCase3() {
        System.out.println("This is testCase3 with @Test");
    }

    @Test(groups = "client")
    public void testCase4() {
        System.out.println("This is testCase4 with @Test");
    }
    @BeforeGroups("server")
    public void beforeServerGroup() {
        System.out.println("beforeServerGroup");
    }
    @AfterGroups("server")
    public void afterServerGroup() {
        System.out.println("afterServerGroup");
    }
  
}
