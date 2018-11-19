package com_mapbar_cross_road_query.com_mapbar_cross_road_query.common;

public enum EnumResultCode implements ResultState{
    SUCCESS(200, "操作成功"),
    PARAME_NOFOUND(1001, "参数不能为空!"),
    DATA_NOFOUND(1002, "未查询到数据!"),
    ERROR(500, "服务器内部错误!");
    EnumResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;

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

    @Override
    public int status() {
        return this.status;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public int httpCode() {
        // TODO Auto-generated method stub
        return 0;
    }
}
