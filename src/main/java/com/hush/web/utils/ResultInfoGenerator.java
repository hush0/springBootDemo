package com.hush.web.utils;

/**
 * @Author: huangshuai
 * @Date: 2020-11-06
 * @Version 1.0
 */
public class ResultInfoGenerator {

    private ResultInfoGenerator() {

    }

    /**
     * 生成正确处理结果模型
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultInfo<T> ok(T data) {
        return status(ResultStatus.SUCCESS, data);
    }


    /**
     * 生成失败处理结果模型
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultInfo<T> fail(T data) { return status(ResultStatus.FAILED, data); }


    /**
     * 依据状态枚举生成处理结果模型
     *
     * @param resultStatus
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultInfo<T> status(ResultStatus resultStatus, T data) {
        return new ResultInfo<>(resultStatus, data);
    }

    /**
     * 依据状态枚举生成处理结果模型
     *
     * @param resultStatus
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultInfo<T> status(ResultStatus resultStatus, String message, T data) {
        return new ResultInfo<>(resultStatus, message, data);
    }
}
