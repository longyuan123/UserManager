package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DbUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserInfoListTest() throws IOException, InterruptedException {
        SqlSession sqlSession= DbUtil.getSqlSession();
        GetUserListCase getUserListCase=sqlSession.selectOne("getUserListCase",3);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //下边为写完接口的代码
        //Actural result
        List<User>  acturalResults = getJsonResult(getUserListCase);
        System.out.println("actual result ");
        for(User u : acturalResults){
            System.out.println("actual result :"+u.toString());
        }
        /**
         * 可以先讲
         */
        Thread.sleep(2000);
        //Expected result
        List<User> expectResults = sqlSession.selectList(getUserListCase.getExpected(),getUserListCase);
        System.out.println("Expect result");
        for(User u : expectResults){
            System.out.println("list获取的user:"+u.toString());
        }
        Assert.assertEquals(expectResults.size(),acturalResults.size());
        for (int i=0; i< acturalResults.size();i++) {
            User actual =   acturalResults.get(i);
            User expect =   expectResults.get(i);
            Assert.assertEquals(expect.toString(), actual.toString());
        }
    }

    private List<User>  getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
//        //设置cookies
//        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = TestConfig.httpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        List<User>  resultList =  new ArrayList<User>();
       JSONArray jsonArray = new JSONArray(result);
        for(int i=0;i<jsonArray.length();i++){
            User u = new User();
            JSONObject obj = (JSONObject) jsonArray.get(i);
            u.setId(obj.getInt("id"));
            u.setUserName(obj.getString("userName").valueOf(obj.get("userName")));
            u.setPassword(obj.getString("password"));
            u.setAge(obj.getString("age"));
            u.setSex(obj.getString("sex"));
            u.setPermission(String.valueOf(obj.get("permission")));
            u.setIsDelete(String.valueOf(obj.get("isDelete")));
            resultList.add(u);
        }
        return resultList;
    }
}
