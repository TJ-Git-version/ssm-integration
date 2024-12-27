package com.surfur.ssm.common;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ResultUtil<T> implements Serializable {

    private Integer code;

    private Boolean success;

    private T data;

    public ResultUtil() {
    }

    public ResultUtil(Integer code, Boolean success, T data) {
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public static <T> ResultUtil<T> ok() {
        return ResultUtil.build(null);
    }

    public static <T> ResultUtil<T> ok(T data) {
        return ResultUtil.build(data);
    }

    public static <T> ResultUtil<T> build(T data) {
        return ResultUtil.build(true, data);
    }

    public static <T> ResultUtil<T> build(Boolean success, T data) {
        return ResultUtil.build(HttpStatus.OK.value(), success, data);
    }

    public static <T> ResultUtil<T> build(Integer code, Boolean success, T data) {
        return new ResultUtil<T>(code, success, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
