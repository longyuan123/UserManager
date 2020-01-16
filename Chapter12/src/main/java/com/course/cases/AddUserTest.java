package com.course.cases;

import com.course.util.DataBaseHanlder;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class AddUserTest {
    public void addUser() throws IOException {
        SqlSession sqlSession = DataBaseHanlder.getSqlSession();
        AddUserTest addUserTest = sqlSession.selectOne("addUserCase");
    }
}
