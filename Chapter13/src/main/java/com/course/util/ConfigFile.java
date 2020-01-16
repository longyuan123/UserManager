package com.course.util;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINESE);

    public static String getUri(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String result=null;

        switch (name){
            case LOGIN:
                result = bundle.getString("login.uri");
                break;
            case ADDUSER:
                result = bundle.getString("addUser.uri");
                break;
            case GETUSERINFO:
                result = bundle.getString("getUserInfo.uri");
                break;
            case UPDATEUSERINFO:
                result = bundle.getString("updateUserInfo.uri");
                break;
            case GETUSERLIST:
                result = bundle.getString("getUserList.uri");
                break;
        }

        return address + result;

    }
}
