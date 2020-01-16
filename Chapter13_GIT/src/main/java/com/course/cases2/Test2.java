package com.course.cases2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void testJia(){
        Assert.assertTrue(true);
    }
    @Test
    public void testJian(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void testCheng(){
        Assert.assertTrue(false);
    }
}
