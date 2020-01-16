package com.course.cases;

import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.util.DataBaseHanlder;
import com.course.util.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "get user where userid = 1")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DataBaseHanlder.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfo",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.GETUSERINFOURL);

        JSONArray resultJson = getJsonResult(getUserInfoCase);
        Thread.sleep(3000);
        User user = sqlSession.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        List userList = new ArrayList();
        userList.add(user);
        JSONArray jsonArray = new JSONArray(userList);
        Assert.assertEquals(jsonArray,resultJson);
    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost post = new HttpPost();
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserId());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setHeader("content-type","application/json");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        List resultList = Arrays.asList(result);//Important!
        JSONArray array = new JSONArray(resultList);
        return  array;
    }
}
