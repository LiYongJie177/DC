package com.kdkj.dc.enums;

public enum  DictType {
    /**
     * 启用
     */
    ENABLE(0),
    /**
     * 禁用
     */
    DISABLE(1);

    private int value;

    private DictType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
