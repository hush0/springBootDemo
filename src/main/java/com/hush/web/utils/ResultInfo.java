package com.hush.web.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: huangshuai
 * @Date: 2020-11-06
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResultInfo<T> {
    /**
     * 状态码
     */
    private int status;

    /**
     * 状态码对应的信息
     */
    private String message;

    /**
     * 返回的结果
     */
    private T data;

    private ResultInfo() {

    }

    public ResultInfo(ResultStatus resultStatus, T data) {
        this.status = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    public ResultInfo(ResultStatus resultStatus, String message, T data) {
        this.status = resultStatus.getCode();
        this.message = message;
        this.data = data;
    }

    public static ResultInfo success(){
        return success(null);
    }

    public static ResultInfo success(Object data){
        ResultInfo result = new ResultInfo();
        result.setStatus(ResultStatus.SUCCESS.getCode());
        result.setMessage(ResultStatus.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static ResultInfo error(String message){
        ResultInfo result = new ResultInfo();
        result.setData(null);
        result.setMessage(message);
        result.setStatus(ResultStatus.FAILED.getCode());
        return result;
    }


    public static ResultInfo error(Integer code, String message){
        ResultInfo result = new ResultInfo();
        result.setData(null);
        result.setStatus(code);
        result.setMessage(message);
        return result;
    }
}
