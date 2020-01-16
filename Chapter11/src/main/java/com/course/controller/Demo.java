package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@Log4j
@RestController
@Api(value = "v1")
@RequestMapping("v1")
public class Demo {

    //首先获取一个执行sql语句的对象
    @Autowired //启动就加载(预加载)
    private SqlSessionTemplate template;

    @RequestMapping(value = "getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "This is a interface to get user count", httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ApiOperation(value = "This is a interface to add user", httpMethod = "POST")
    public int addUser(@RequestBody User user){
        int result =  template.insert("addUser",user);

        return result;
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "This is a interface to update user", httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        int result =  template.update("updateUser",user);
        return result;
    }
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    @ApiOperation(value = "This is a interface to delete user", httpMethod = "POST")
    public int deleteUser(@RequestBody User user){
        int result =  template.delete("deleteUser",user);
        return result;
    }
}
