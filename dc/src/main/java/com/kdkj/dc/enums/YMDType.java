package com.kdkj.dc.enums;

public enum  YMDType {
    /**
     * 年
     */
    YEAR(0),
    /**
     * 月
     */
    MONTH(1),
    /**
     * 日
     */
    DAY(2);

    private int value;

    private YMDType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
