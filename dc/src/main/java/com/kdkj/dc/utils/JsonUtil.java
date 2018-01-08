package com.kdkj.dc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kdkj.dc.entity.SysUser;

/**
 *  json工具类
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
