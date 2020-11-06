package com.hush.web.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: huangshuai
 * @Date: 2020-11-06
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum ResultStatus {
    FAILED(-1,"失败"),
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数无效"),
    VALIDATE_ERROR(2, "参数验证失败"),
    UNKNOWN_ERROR(3,"未知错误"),

    UN_AUTHENTICATION(401, "请首先登陆系统"),
    UN_AUTHORIZED(403, "您没有权限访问该资源"),
    NOT_FOUND(404, "请求资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),

    TOKEN_INVALID(4001, "无效的Token"),
    TOKEN_MISSION(4002, "token缺失"),

    PROCESS_EXCEPTION(80001, "业务处理失败"),
    FILE_TRANSFORM_EXCEPTION(80002, "文件传输错误!"),
    FILE_NOT_EXIST_EXCEPTION(80003,"文件不存在!");

    private int code;

    private String message;
}
