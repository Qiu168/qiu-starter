package com.example.www;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author Lion Li
 */
@Data
@NoArgsConstructor
public class R implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 失败
     */
    public static final int FAIL = 500;

    private int code;

    private String msg;

    private Object data;

    public static R ok() {
        return restResult(null, SUCCESS, "操作成功");
    }

    public static <T> R ok(T data) {
        return restResult(data, SUCCESS, "操作成功");
    }

    public static <T> R ok(String msg) {
        return restResult(null, SUCCESS, msg);
    }

    public static <T> R ok(String msg, T data) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R fail() {
        return restResult(null, FAIL, "操作失败");
    }

    public static <T> R fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> R fail(T data) {
        return restResult(data, FAIL, "操作失败");
    }

    public static <T> R fail(String msg, T data) {
        return restResult(data, FAIL, msg);
    }

    public static <T> R fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> R warn(String msg) {
        return restResult(null, 400, msg);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> R warn(String msg, T data) {
        return restResult(data, 400, msg);
    }

    private static <T> R restResult(T data, int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static <T> Boolean isError(R ret) {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(R ret) {
        return R.SUCCESS == ret.getCode();
    }
}
