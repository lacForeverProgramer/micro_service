package com.lacForever.Enum;

/**
 * @Author: Liujiahao
 * @Date: 19-1-21 下午2:44
 */
public enum BaiduEnum {
    GRANT_TYPE("grant_type","client_credentials"),
    CLIENT_ID("client_id","5USpCTgPGVC717Ar2x7dYmNZ"),
    CLIENT_SECRET("client_secret","Lqz7whKVImMYDC024nvKyztXPnXK9g2c");

    private String key;

    private String value;

    BaiduEnum(String key,String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
