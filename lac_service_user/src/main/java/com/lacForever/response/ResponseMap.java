package com.lacForever.response;

import com.lacForever.Enum.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liujiahao
 * @Date: 19-1-11 上午10:47
 * 返回参数封装
 */
public class ResponseMap {
    private static class ResponseMapHolder {
        private static final ResponseMap instance = new ResponseMap();
    }

    private ResponseMap() {

    }

    public static final ResponseMap getInstance() {
        return ResponseMapHolder.instance;
    }

    public Map getOKMap() {
        Map map = new HashMap();
        map.put("result", Status.OK.getCode());
        map.put("message", Status.OK.getValue());
        map.put("info", "");
        return map;
    }

    public Map getStatusMap(Status status) {
        Map map = new HashMap();
        map.put("result", status.getCode());
        map.put("message", status.getValue());
        return map;
    }

    public Map getInfoMap() {
        Map map = new HashMap();
        return map;
    }
}
