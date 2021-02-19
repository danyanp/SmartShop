package com.danyanpi.bean;

import lombok.Data;

/**
 * 基础返回类
 */
@Data
public class BaseResponse<T> {
    /**
     * 是否成功 0失败 1成功
     */
    private Integer code;
    /**
     * 说明
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }
    public BaseResponse(int issuccess, String msg) {
        this.code = issuccess;
        this.message = msg;
        this.data = null;
    }
    public BaseResponse(int issuccess, String msg, T data) {
        this.code = issuccess;
        this.message = msg;
        this.data = data;
    }

}