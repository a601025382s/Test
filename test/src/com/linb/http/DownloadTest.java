package com.linb.http;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class DownloadTest {
    
    public static void main(String[] args) throws IOException {
        Integer startFirst = 0;
        Integer endFirst = 1023;
        Integer startSecond = 1024;
        Integer endSecond = null;
        dowloadPartFile(startFirst, endFirst); // 下载第一部分，0-1023字节
        dowloadPartFile(startSecond, endSecond);// 下载第二部分
    }
    
    public static void dowloadPartFile(Integer start, Integer end) throws IOException {
        byte[] res = null;
        res = download(start, end);
        FileOutputStream fs = new FileOutputStream("C:/Users/ucmed/Desktop/0.jpg", true);
        if (null != res) {
            System.out.println(res.length);
            fs.write(res, 0, res.length);
            fs.close();
        }
    }
    
    public static byte[] download(Integer start, Integer end) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet("http://yilian001-10001356.image.myqcloud.com/b577071a-06b4-40dc-b4e7-b8c8d559f80d");
        if (null != start) {
            String range = "bytes=" + start + "-";
            if (null != end) {
                range += end;
            }
            System.out.println(range);
            httpGet.setHeader("Range", range);
        }
        byte[] res = null;
        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null != httpEntity) {
                res = EntityUtils.toByteArray(httpEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
