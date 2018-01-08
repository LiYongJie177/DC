package com.kdkj.dc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}