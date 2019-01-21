package com.lacForever.service.impl;

import com.lacForever.Enum.BaiduEnum;
import com.lacForever.annotation.Cach;
import com.lacForever.service.TheThirdPartyService;
import com.lacForever.util.HttpUtil;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Service;

/**
 * @Author: Liujiahao
 * @Date: 19-1-21 下午2:56
 */
@Service("TheThirdPartyService")
public class TheThirdPartyServiceImpl implements TheThirdPartyService{
    @Override
    //百度情绪接口 获取accesstoken
    @Cach(key = "baiduToken",type = String.class,expire = 20*60*60*24L)
    public String getAuth() {
        String url = "https://aip.baidubce.com/oauth/2.0/token?"+
                BaiduEnum.GRANT_TYPE.getKey()+"="+BaiduEnum.GRANT_TYPE.getValue()+"&"+
                BaiduEnum.CLIENT_ID.getKey()+"="+BaiduEnum.CLIENT_ID.getValue()+"&"+
                BaiduEnum.CLIENT_SECRET.getKey()+"="+BaiduEnum.CLIENT_SECRET.getValue()+"&";
        return HttpUtil.post(url,"");
    }
}
