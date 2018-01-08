package com.kdkj.dc.utils;

import com.kdkj.dc.enums.CodeEnum;

/**
 * enum通过code获取对应的值(工具类)
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
