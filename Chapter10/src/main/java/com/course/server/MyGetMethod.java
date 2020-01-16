package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/")
public class MyGetMethod {

   @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
   @ApiOperation(value = "Get cookies by get method....")
   public String getMyCookies(HttpServletResponse response){
       //HttpServerletRequest request info class
      // HttpServerletResponse response info class
      Cookie cookie = new Cookie("login","true");
      cookie.setComment("Set comment");

      response.addCookie(cookie);
      return "Congratulations on your successful cookie information!" ;
   }

   /**
    * Require cookies when requested by the client
    * 需要携带cookies信息才能访问的get请求
    */

   @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
   @ApiOperation(value = "getWithCookies by get method....")
   public String getWithCookies(HttpServletRequest request){
      Cookie[] cookies = request.getCookies();
      if(Objects.isNull(cookies)){
         return "cookie is null!  Cookie information is required!";
      }

      for (Cookie c:cookies) {
         System.out.println("name="+c.getName() + ",value=" +c.getValue() );
         if("login".equals(c.getName()) && "true".equals(c.getValue())){
            return "Congratulations!" ;
         }
      }
      return "Error! Cookie information is required!!!";
   }

   /**
    * 开发一个需要携带参数才能访问的get请求
    * 第一种实现方式： url : key=value&key=value
    * 模拟获取商品列表 http://localhost:8888/get/with/param?start=1&end=20
    */
   @RequestMapping(value = "/get/with/param" ,method = RequestMethod.GET)
   @ApiOperation(value = "getList by get method....")
   public Map<String, Float> getList(@RequestParam Integer start, @RequestParam Integer end){
      Map<String, Float> list = new HashMap<>();
      list.put("shoes",400f);
      list.put("Jacket",120f);
      list.put("hat", 20.5f);
      return list;
   }

   /**
    * 第二种需要携带参数访问的get请求
    * url value/value
    * http://localhost:8888/get/with/param/1/20
    */

   @RequestMapping(value = "/get/with/param/{start}/{end}" ,method = RequestMethod.GET)
   @ApiOperation(value = "getList2 by get method....")
   public Map<String, Float> getList2(@PathVariable Integer start, @PathVariable Integer end){
      Map<String, Float> list = new HashMap<>();
      list.put("shoes",400f);
      list.put("Jacket",120f);
      list.put("hat", 20.5f);
      return list;
   }
}
