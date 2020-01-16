package com.yywang.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
  @Test
  public void loginSuccess() {
      System.out.println("Login success test");
  } 
  @Test
  public void loginFailed() {
      System.out.println("login failed test");
  } 
  
  @BeforeMethod
  public void beforeMethod() {
      System.out.println("before loginTest");
  }

  @AfterMethod
  public void afterMethod() {
      System.out.println("after loginTest");
  }
}
