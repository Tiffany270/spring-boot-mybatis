package yiki.mybatis.react_app_util;

/*
 * /register - post
 * success：{code:0,
 *           data:{
 *                   _id:'abc',
 *                   username:'xxx',
 *                   psw:'xxx'}}
 * failure:{code:0.
 *           msg:'error'}
 * */

public class Result<T> {
    private Integer status = -1;
    private String msg;
    private T data;
    private boolean success;

    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.success = false;
    }

    public Result(T result) {
        this.status = 227;
        this.msg = "ok";
        this.data = result;
        this.success = true;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result error(Integer errorcode, String errormsg) {
        return new Result(errorcode, errormsg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
