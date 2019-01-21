package com.lacForever.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Liujiahao
 * @Date: 19-1-21 下午2:22
 */
public class HttpUtil {

    private static Logger logger = Logger.getLogger(HttpUtil.class);

//    返回对象
    public static CloseableHttpClient defaultHttpClient(){
        return HttpClientBuilder.create().build();
    }
    //get 请求
    public static String get(String url){
        try {
            CloseableHttpClient client = HttpUtil.defaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            logger.info("请求URL" + url +";code: "+code);
            if(code == HttpStatus.SC_OK){
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String post(String url, String params){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        if(params!=""){
            StringEntity entity = new StringEntity(params, StandardCharsets.UTF_8);
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            logger.info("请求URL：" + url + ";code："+ code);
            if (code == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            if (response != null) {
                response.close();
            }
            httpclient.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
