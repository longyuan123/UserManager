package com.yywang.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FavTest {
  @Test
  public void favTest() {
      System.out.println("FavTest");
  }
  
  @BeforeMethod
  public void beforeMethod() {
      System.out.println("before FavTest");
  }

  @AfterMethod
  public void afterMethod() {
      System.out.println("after FavTest");
  }
}
