package com.course.cases;

import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.util.ConfigFile;
import com.course.util.DataBaseHanlder;
import com.course.util.TestConfig;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "loginTrue", description = "Prepared for testing...")
    public void beforeTest(){
        TestConfig.ADDUSERURL = ConfigFile.getUri(InterfaceName.ADDUSER);
        TestConfig.GETUSERINFOURL = ConfigFile.getUri(InterfaceName.GETUSERINFO);
        TestConfig.GETUSERLISTURL = ConfigFile.getUri(InterfaceName.GETUSERLIST);
        TestConfig.LOGINURL = ConfigFile.getUri(InterfaceName.LOGIN);
        TestConfig.UPDATEUSERINFOURL = ConfigFile.getUri(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void test(){
        try{
            SqlSession sqlSession  = DataBaseHanlder.getSqlSession();
            LoginCase loginCase =   sqlSession.selectOne("LoginCase");
            System.out.println("loginCase" + loginCase);
        }catch (IOException e){
            System.out.println("loginCase e" + e);
        }

    }


}
