package com.course.cases;


import com.course.model.AddUserCase;
import com.course.model.InterfaceName;
import com.course.model.User;
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
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;

public class AddUserTest {


    @Test (dependsOnGroups = { "loginTrue" } , description = "add user interface")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DataBaseHanlder.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println("url = "+TestConfig.ADDUSERURL);
        Thread.sleep(3000);
        //send request get result
        String result = getResult(addUserCase);
        Thread.sleep(3000);
        //verify result
        User user = session.selectOne("addUser",addUserCase);
        Assert.assertEquals(addUserCase.getExpected(),result);
    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.ADDUSERURL);

        JSONObject param = new JSONObject();
        param.put("name", addUserCase.getName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        System.out.println("params=" + param.toString());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //set cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return  result;
    }
}
