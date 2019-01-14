package com.lacForever.Enum;

/**
 * @Author: Liujiahao
 * @Date: 19-1-11 上午10:43
 */
public enum Status {
    Fail("失败",-1),
    OK("成功",0);


    Status(String value, int code) {
        this.value = value;
        this.code = code;
    }

    private String value;
    private int code;



    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
