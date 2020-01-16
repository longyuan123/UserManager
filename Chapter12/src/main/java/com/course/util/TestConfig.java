package com.course.util;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {
    public static String LOGINURL;
    public static String GETUSERLISTURL;
    public static String GETUSERINFOURL;
    public static String ADDUSERURL;
    public static String UPDATEUSERINFOURL;
    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;
}
