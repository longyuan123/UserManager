package com.yywang;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertTest {
  @Test
  public void test1() {
      Assert.assertEquals(1, 1);
  }
  
  @Test
  public void test2() {
      Assert.assertEquals(1, "1");
  }
  
  @Test
  public void test3() {
      Assert.assertEquals("abc", "abc");
  }
  
  @Test
  public void logDemo() {
      Reporter.log("This is my reporter log");
     // throw new RuntimeException("this is my runtime exception");
  }
}
