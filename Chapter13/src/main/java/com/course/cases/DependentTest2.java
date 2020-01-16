package com.course.cases;

import org.testng.annotations.Test;

public class DependentTest2 {
    @Test(dependsOnGroups = { "test-group" })
    public void groupTestInTest2() {
        System.out.println("Group Test method in test2");
    }
}
