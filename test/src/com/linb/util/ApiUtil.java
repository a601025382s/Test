package com.linb.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ApiUtil {

    private static final Logger LOG = Logger.getLogger(ApiUtil.class);
    
    public static void main(String[] args) {
        JSONObject params = new JSONObject();
        params.put("phone", "15056252687");
        params.put("password", "91b4d142823f7d20c5f08df69122de43f35f057a988d9619f6d3138485c9a203");
        String res = getApiRes("http://182.254.129.153:18480/api/exec/ylpt.htm", "api.ylpt.user.login", params);
        System.out.println("login res : " + res);
        JSONObject loginRes = JSONObject.fromObject(res);
        if (loginRes.optInt("R") != 200) {
            System.out.println("登录失败");
        }
        String S = loginRes.optString("S");
        for (int i = 0; i < 10000; i++) {
            JSONObject p = new JSONObject();
            p.put("S", S);
            String ret = getApiRes("http://182.254.129.153:18480/api/exec/ylpt.htm", "api.ylpt.user.auto.login", p);
            JSONObject json = JSONObject.fromObject(ret);
            if (null == ret || json.optInt("R") != 200) {
                System.out.println("自动登录失败" + i);
                System.out.println(ret);
                break;
            }
            S = json.optString("S");
        }
    }
    
    public static String getApiRes(String url, String apiName, JSONObject params) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        JSONObject requestData = new JSONObject();
        requestData.put("TX", apiName);
        requestData.put("V", "1.0.0");
        requestData.put("T", "4");
        requestData.put("D", "P00001");
        requestData.put("login_flag", "4");
        requestData.putAll(params);
        System.out.println("requestData : " + requestData.toString());
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();

        System.out.println("api requestData:" + requestData.toString());
        entity.addTextBody("requestData", requestData.toString());

        httpPost.setEntity(entity.build());

        String res = null;
        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null != httpEntity) {
                res = (String) EntityUtils.toString(httpEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    /**
     * @Description api请求,包含文件上传, by linb
     * @param url api地址
     * @param apiName api名称
     * @param params api参数
     * @param request 文件流
     * @param fileName 文件名称,医链api基本格式为attachment_x，x为第几张图片
     * @return api请求结果
     * @throws IOException IOException
     */
    public static String getApiRes(String url, String apiName, JSONObject params, MultipartHttpServletRequest request, String fileName) throws IOException {
     // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        JSONObject requestData = new JSONObject();
        requestData.put("TX", apiName);
        requestData.put("V", "1.0.0");
        requestData.put("T", "17");
        requestData.putAll(params);
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();
        // 文件流
        MultipartFile mf = request.getFile(fileName);
        entity.addBinaryBody(mf.getName(), mf.getBytes(), ContentType.TEXT_HTML, mf.getOriginalFilename());
        LOG.info("api requestData:" + requestData.toString());
        entity.addTextBody("requestData", requestData.toString());

        httpPost.setEntity(entity.build());

        String res = null;
        try {
            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null != httpEntity) {
                res = (String) EntityUtils.toString(httpEntity);
            }
        } catch (Exception e) {
            LOG.error("httpPost error ", e);
        }
        return res;
    }
}
