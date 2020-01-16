package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;

    //模拟用户登录成功获取Cookies 然后再访问其他接口获取xx列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("yywang") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "login successfully!";
        }

        return "user name or password is error!";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u) {
        //get Cookies
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies))
            return "Cookie is null";
        User user = new User();
        for (Cookie c :
                cookies) {
            if (c.getName().equals("login") && c.getValue().equals("true")) {
                if( u.getName().equals("yywang") && u.getPassword().equals("123456")){
                    user.setName("yywang");
                    user.setPassword("123456");
                    user.setAge(30);
                    user.setSex("M");
                    return user.toString();
                }
               return "User Name or password is wrong!";
            }
        }
        return "No this cookies";
    }


}
