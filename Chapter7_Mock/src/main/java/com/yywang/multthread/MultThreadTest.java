package com.yywang.multthread;

import org.testng.annotations.Test;

public class MultThreadTest {
  @Test
  public void test1() {
      System.out.println("test1 " + Thread.currentThread().getId());
  }
  @Test
  public void test2() {
      System.out.println("test2 " + Thread.currentThread().getId());
  }
  @Test
  public void test3() {
      System.out.println("test3 " + Thread.currentThread().getId());
  }
}
