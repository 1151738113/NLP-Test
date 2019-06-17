package com.nlp.learn.test;


import com.nlp.learn.util.Base64Util;
import com.nlp.learn.util.FileUtil;
import com.nlp.learn.util.HttpUtil;

import java.net.URLEncoder;

public class Idcard {


    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static void main(String[] args) {
        // 身份证识别url
//        String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
        // 本地图片路径
        String filePath = "E:\\workspace\\project\\NLP-Test\\data\\car.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
//            String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
//                    + URLEncoder.encode(imgStr, "UTF-8");
            String params = URLEncoder.encode("image", "UTF-8") + "="+
                    URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = AuthService.getAuth();
//            String accessToken = "MMGxYr8mrQ4yTzBAke16tKKlywYEZEjl";
            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
