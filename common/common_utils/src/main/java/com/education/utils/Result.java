package com.education.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result<T> {


    @ApiModelProperty(name = "code",value = "响应状态码")
    private Integer code;

    @ApiModelProperty(name = "msg",value = "提示消息")
    private String msg;

    @ApiModelProperty(name = "data",value = "响应数据")
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static<T> Result<T> ok(T data){
        Result<T> resp = new Result<T>(data);
        resp.setCode(20000);//操作成功
        resp.setMsg("success");
        return resp;
    }

    public static<T> Result<T> fail(String data){
        Result<T> resp = new Result<T>();
        resp.setCode(20001);//操作失败
        resp.setMsg(data);
        return resp;
    }

    public Result<T> msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
