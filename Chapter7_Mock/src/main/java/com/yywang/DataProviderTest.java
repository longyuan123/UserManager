package com.yywang;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "paramter")
    public void testDataProvider(String name, int age) {
        System.out.println("testDataProvider - name="+name +",age=" + age );
    }

    @DataProvider(name="paramter")
    public  Object[][] dataProvider() {
        System.out.println("dataProvider");
        Object[][] obj = new Object[][] {
            {"zhangsan", 10},{"lisi", 20},{"wangwu", 30}
        };
        return obj;
    }
    
    @Test(dataProvider = "methodParamter")
    public void testMethodDataProvider1(String name, int age) {
        System.out.println("testMethodDataProvider1 - name="+name +",age=" + age );
    }
    @Test(dataProvider = "methodParamter")
    public void testMethodDataProvider2(String name, int age) {
        System.out.println("testMethodDataProvider2 - name="+name +",age=" + age );
    }
    
    @DataProvider(name="methodParamter")
    public  Object[][] methodDataProvider(Method method) {
        System.out.println("methodDataProvider");
        Object[][] obj = null;
        if(method.getName().equals("testMethodDataProvider1")) {
            obj = new Object[][] {
                {"bo", 10},{"hao", 20},{"yuan", 30}
            };
        }else if(method.getName().equals("testMethodDataProvider2")) {
            obj = new Object[][] {
                {"chen", 10},{"long", 20},{"wang", 30}
            };
        }
        return obj;
    }
}
