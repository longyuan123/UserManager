package com.course.cases;

import com.course.model.GetUserListCase;
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

import java.io.IOException;
import java.util.List;

public class GetUserInfoListTest {

    @Test(dependsOnGroups = "loginTrue",description = "get users sex = man")
    public void getUserListInfo() throws IOException, InterruptedException {
        SqlSession session = DataBaseHanlder.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListInfo");
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.GETUSERLISTURL);

        //1.Send request and get result
        JSONArray result = getJsonResult(getUserListCase);
        Thread.sleep(3000);
        //2.Verfiy result

        List<User> userList = session.selectList(getUserListCase.getExpected());
        for(User u: userList){
            System.out.println("Get user: " + u.getName());
        }

        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(),result.length());

        for(int i=0;i<result.length();i++){
            JSONObject expect = (JSONObject) result.get(i);
            JSONObject actual= (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(),actual.toString());
        }
    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.GETUSERLISTURL);
        JSONObject param = new JSONObject();
        param.put("name",getUserListCase.getName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        post.setHeader("content-type","application/json");
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;
    }
}
