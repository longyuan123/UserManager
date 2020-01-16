package com.course.cases;

import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.util.ConfigFile;
import com.course.util.DataBaseHanlder;
import com.course.util.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.ADDUSERURL = ConfigFile.getUri(InterfaceName.ADDUSER);
        TestConfig.GETUSERINFOURL = ConfigFile.getUri(InterfaceName.GETUSERINFO);
        TestConfig.GETUSERLISTURL = ConfigFile.getUri(InterfaceName.GETUSERLIST);
        TestConfig.LOGINURL = ConfigFile.getUri(InterfaceName.LOGIN);
        TestConfig.UPDATEUSERINFOURL = ConfigFile.getUri(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(groups = "loginTrue", description = "login success interface")
    public void loginTrue(){
        try{
            SqlSession sqlSession  = DataBaseHanlder.getSqlSession();
            LoginCase loginCase =   sqlSession.selectOne("LoginCase",1);
            System.out.println("loginCase" + loginCase);
            //1. Send request
            String result = getResult(loginCase);
            Thread.sleep(3000);
            //2.verfiy result
            Assert.assertEquals(loginCase.getExpected(),result);

        }catch (IOException | InterruptedException e){
            System.out.println("loginCase e" + e);
        }

    }


    @Test(groups = "loginFalse", description = "login false interface")
    public void loginFalse(){
        try{
            SqlSession sqlSession  = DataBaseHanlder.getSqlSession();
            LoginCase loginCase =   sqlSession.selectOne("LoginCase",2);
            System.out.println("loginCase" + loginCase);
            //1. Send request
            String result = getResult(loginCase);
            Thread.sleep(3000);
            //2.verfiy result
            Assert.assertEquals(loginCase.getExpected(),result);
        }catch (IOException | InterruptedException e){
            System.out.println("loginCase e" + e);
        }

    }

    private String getResult(LoginCase loginCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.LOGINURL);
        JSONObject param = new JSONObject();
        param.put("name",loginCase.getName());
        param.put("password", loginCase.getPassword());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        String result = null;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString( response.getEntity(), "utf-8");
        System.out.println("login result = " + result);
       // TestConfig.cookieStore=TestConfig.defaultHttpClient.getCookieStore();
        return  result;


    }




}
