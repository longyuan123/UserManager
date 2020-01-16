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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

//@Log4j
@RestController
@Api(value = "v1")
@RequestMapping("v1")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;



    @ApiOperation(value = "login", httpMethod = "POST")
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        int i = template.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        Logger.getLogger("UserManager").info("Login"+i);
        if(i==1){
            log(user.getName() + "Login"+i);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "add user", httpMethod = "POST")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Boolean addUser(HttpServletRequest request, @RequestBody User user){
        Boolean verifyCookies = verifyCookies(request);
        int result = 0;
        if(verifyCookies){
            result  = template.insert("addUser", user);
        }

        if(result>0){
            log("insert user number:" + result );
            return true;
        }

        return false;
    }


    @ApiOperation(value = "get user info" , httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean verifyCookies = verifyCookies(request);
        List<User> result = null;
        if(verifyCookies != null){
            result  = template.selectList("getUserInfo",user);
            log("get user number:"+ result.size());
        }
        return result;
    }
    @ApiOperation(value = "update user info" , httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public int updateUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean verifyCookies = verifyCookies(request);
        int result = 0;
        if(verifyCookies){
            result  = template.update("updateUserInfo",user);
            log("update user number:"+ result);
        }
        return result;
    }

    private Boolean verifyCookies(HttpServletRequest request){
        Cookie[] cookies= request.getCookies();
        if(Objects.isNull(cookies)){
            Logger.getLogger("UserManager").info("Cookie is null!");
            return false;
        }
        for (Cookie c : cookies){
            if(c.getName().equals("login") && c.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }

    private void log(String log){
        Logger.getLogger("UserManager").info(log);
    }
}
