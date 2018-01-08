package com.kdkj.dc.utils;

import com.kdkj.dc.entity.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}
