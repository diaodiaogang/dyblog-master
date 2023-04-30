package com.diaoyang.exception;

import com.diaoyang.common.AppHttpCodeEnum;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/29 17:14
 * @Version : V1.0
 * @Description :
 */
public class SystemException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}
