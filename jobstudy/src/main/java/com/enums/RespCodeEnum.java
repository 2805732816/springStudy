package com.enums;


import lombok.Getter;

@Getter
public enum RespCodeEnum {
    SUCCESS(200,"响应成功"),
    FAIL(500,"服务器内部错误"),



    ;
    private int code;
    private String desc;

    RespCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
