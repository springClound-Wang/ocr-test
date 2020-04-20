package com.zjw.ocr.api;


import com.zjw.ocr.util.Base64Util;
import com.zjw.ocr.util.FileUtil;
import com.zjw.ocr.util.HttpUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.net.URLEncoder;
public class Receipt {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String receipt(MultipartFile ocr) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/receipt";
        try {
            // 本地文件路径
            String filePath = "C:\\Users\\11420\\Desktop\\a1.jpg";
            byte[] imgData = ocr.getBytes();//FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.91695167a24f7be5f660e19fb9f77e63.2592000.1589873960.282335-19499621";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        //Receipt.receipt();
    }
}