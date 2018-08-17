package com.nlp.learn.data;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;


/**
 * Created by wei.wang on 2018/7/23 0023.
 *
 */
public class LtpConnect {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LtpConnect.class);

    public String connect(String value){
       String text = "s="+value+"&t=all";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://192.168.8.108:9055/ltp");
            httpPost.setHeader("Content-Type", "text/plain; utf-8");
            HttpEntity entity = new StringEntity(text, Charset.forName("UTF-8"));
            httpPost.setEntity(entity);
            HttpResponse result = httpclient.execute(httpPost);
            HttpEntity httpEntity = result.getEntity();
            String respContent = EntityUtils.toString(httpEntity , "UTF-8").trim();
            httpclient.getConnectionManager().shutdown();
            return respContent;
        } catch (Exception e) {
            logger.error("连接失败");
        }
       return  "";
    }

    public static void main(String[] args) throws Exception{

        String text = "s=中华人民共和国&t=all";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://192.168.8.108:9055/ltp");
            httpPost.setHeader("Content-Type", "text/plain; utf-8");
            HttpEntity entity = new StringEntity(text, Charset.forName("UTF-8"));
            httpPost.setEntity(entity);
            HttpResponse result = httpclient.execute(httpPost);
            HttpEntity httpEntity = result.getEntity();
            String respContent = EntityUtils.toString(httpEntity , "UTF-8").trim();
            httpclient.getConnectionManager().shutdown();
            System.out.println(respContent);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
