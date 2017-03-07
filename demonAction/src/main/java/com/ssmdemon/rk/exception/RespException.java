package com.ssmdemon.rk.exception;

/**
 * Created by renkai on 2017/3/7.
 * 需要返回前台信息的应该调这个异常类
 */
public class RespException extends RuntimeException {

    public RespException(String message) {
        super(message);
    }
}
