package com.ssmdemon.rk.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by renkai on 2017/3/7.
 * 返回处理
 */
public class RespDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer resStatus;
    private final String resMsg;
    private final Map<String, Object> params = new HashMap<String, Object>();

    public RespDto() {
        this.resStatus = 201;
        this.resMsg = "操作成功";
    }

    public RespDto(Integer resStatus, String resMsg) {
        this.resStatus = resStatus;
        this.resMsg = resMsg;
    }

    public RespDto put(String name, Object value) {
        this.params.put(name, value);
        return this;
    }

    public RespDto putAll(Map<String, ?> params) {
        this.params.putAll(params);
        return this;
    }

    public Integer getResStatus() {
        return resStatus;
    }

    public String getResMsg() {
        return resMsg;
    }

    public Object getParams() {
        return params;
    }
}
