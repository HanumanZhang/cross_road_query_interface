package com_mapbar_cross_road_query.com_mapbar_cross_road_query.common;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultBean<T> {
    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    public ResultBean(){
    }
    public ResultBean(int httpStatus, int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public ResultBean<T> fillResult(ResultState resultState){
        this.status = resultState.status();
        this.message = resultState.message();
        return this;
    }
}
