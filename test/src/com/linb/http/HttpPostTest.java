package com.linb.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpPostTest {
    public static void main(String[] args) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost("http://ylxz.zwjk.com/Home/UserLogin");
        // HttpPost httpPost = new HttpPost("http://ys.ylxz.zwjk.com/Home/UserLogin");
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();
        entity.addTextBody("user", "zheyi_admin");
        entity.addTextBody("pwd", "123456");
        // entity.addTextBody("UserName", "yiwuke@zheyi");
        // entity.addTextBody("Password", "123456");
        entity.addTextBody("unionid", "100");
        entity.addTextBody("ip", "192.168.1.206");
        httpPost.setEntity(entity.build());
        String res = null;
        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null != httpEntity) {
                res = EntityUtils.toString(httpEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------");
        System.out.println(res);
    }
}
