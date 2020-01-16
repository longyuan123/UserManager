package com.course.cases;

import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.util.DataBaseHanlder;
import com.course.util.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "update user info")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession session = DataBaseHanlder.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfo",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.UPDATEUSERINFOURL);

        int result = getResult(updateUserInfoCase);
        Thread.sleep(3000);

        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost();
        JSONObject param = new JSONObject();
        param.put("id",updateUserInfoCase.getUserId());
        param.put("name",updateUserInfoCase.getName());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("age",updateUserInfoCase.getAge());
        param.put("permission",updateUserInfoCase.getPermission());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore((TestConfig.cookieStore));
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
       String result = EntityUtils.toString(response.getEntity(),"utf-8");

        return Integer.parseInt(result);
    }

    @Test(dependsOnGroups = "loginTrue", description = "delete user")
    public void deleteUser() throws IOException {
        SqlSession session = DataBaseHanlder.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfo",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.UPDATEUSERINFOURL);

        int result = getResult(updateUserInfoCase);
        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }
}
