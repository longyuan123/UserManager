package com.yywang.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayTest {
  @Test
  public void payTest() {
      System.out.println("PayTest");
  }
  @BeforeMethod
  public void beforeMethod() {
      System.out.println("before payTest");
  }

  @AfterMethod
  public void afterMethod() {
      System.out.println("after payTest");
  }
}
