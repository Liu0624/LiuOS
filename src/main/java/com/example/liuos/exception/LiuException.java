package com.example.liuos.exception;

import lombok.Data;

@Data
public class LiuException extends RuntimeException{
    //异常消息
    private String msg;
    //状态码
    private int code = 500;

    public LiuException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public LiuException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public LiuException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public LiuException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
