package com.zjw.ocr.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjw.ocr.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * name
 *
 * @author carway
 * @date 2018/7/17.
 */
@RestController
@RequestMapping("/api/ocr")
public class OcrApi {

    @Autowired
    private OcrService ocrService;

    /**
     * 完整路径：http://localhost:80/api/ocr/handle
     * 表单上传 form-datd
     * @param ocr 文件域 ocr
     * @return Json返回体
     */
    @PostMapping("/handle")
    public Object getOcrStructuralization(@RequestParam("ocr")MultipartFile ocr){
        JSONObject jsonObject = new JSONObject();
        byte[] file =null;
        try {
            file = ocr.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            jsonObject.put("result",false);
            jsonObject.put("message","上传图片失败");
        }
        try{
            jsonObject=ocrService.dataHandle(file);
        }catch (Exception e){
            jsonObject.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            jsonObject.put("result",false);
            jsonObject.put("message","图片识别出错");
        }
        return jsonObject;
    }

    @PostMapping("/upFile")
    public String upFile(@RequestParam("ocr")MultipartFile ocr,Integer type){
        //美团1
        if(type==1){
            String result="{\n" +
                    "  \"log_id\": 6529868182750349078,\n" +
                    "  \"type\": 4,\n" +
                    "  \"words_result\": [\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 25,\n" +
                    "        \"left\": 14,\n" +
                    "        \"top\": 86,\n" +
                    "        \"width\": 227\n" +
                    "      },\n" +
                    "      \"words\": \"2017年09月26日15:42:46\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 50,\n" +
                    "        \"left\": 69,\n" +
                    "        \"top\": 130,\n" +
                    "        \"width\": 216\n" +
                    "      },\n" +
                    "      \"words\": \"#1美团外卖\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 24,\n" +
                    "        \"left\": 134,\n" +
                    "        \"top\": 180,\n" +
                    "        \"width\": 86\n" +
                    "      },\n" +
                    "      \"words\": \"沙县小吃\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 54,\n" +
                    "        \"left\": 15,\n" +
                    "        \"top\": 202,\n" +
                    "        \"width\": 326\n" +
                    "      },\n" +
                    "      \"words\": \"在线支付(已支付)\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 25,\n" +
                    "        \"left\": 55,\n" +
                    "        \"top\": 255,\n" +
                    "        \"width\": 252\n" +
                    "      },\n" +
                    "      \"words\": \"【订单号】8088463769241408\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 23,\n" +
                    "        \"left\": 85,\n" +
                    "        \"top\": 282,\n" +
                    "        \"width\": 191\n" +
                    "      },\n" +
                    "      \"words\": \"【下单时间】23:59:53\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 50,\n" +
                    "        \"left\": 35,\n" +
                    "        \"top\": 306,\n" +
                    "        \"width\": 285\n" +
                    "      },\n" +
                    "      \"words\": \"【预计送达时间】\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 45,\n" +
                    "        \"left\": 96,\n" +
                    "        \"top\": 354,\n" +
                    "        \"width\": 159\n" +
                    "      },\n" +
                    "      \"words\": \"立即送达\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 27,\n" +
                    "        \"left\": 117,\n" +
                    "        \"top\": 401,\n" +
                    "        \"width\": 107\n" +
                    "      },\n" +
                    "      \"words\": \"-1号口袋\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 31,\n" +
                    "        \"left\": 24,\n" +
                    "        \"top\": 426,\n" +
                    "        \"width\": 202\n" +
                    "      },\n" +
                    "      \"words\": \"蛋肉丝烤肠炒河粉\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 20,\n" +
                    "        \"left\": 200,\n" +
                    "        \"top\": 462,\n" +
                    "        \"width\": 35\n" +
                    "      },\n" +
                    "      \"words\": \"×1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 19,\n" +
                    "        \"left\": 298,\n" +
                    "        \"top\": 463,\n" +
                    "        \"width\": 25\n" +
                    "      },\n" +
                    "      \"words\": \"13\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 30,\n" +
                    "        \"left\": 26,\n" +
                    "        \"top\": 484,\n" +
                    "        \"width\": 283\n" +
                    "      },\n" +
                    "      \"words\": \"卤鸡腿不是很辣,一般温度\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 20,\n" +
                    "        \"left\": 198,\n" +
                    "        \"top\": 517,\n" +
                    "        \"width\": 36\n" +
                    "      },\n" +
                    "      \"words\": \"×1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 17,\n" +
                    "        \"left\": 307,\n" +
                    "        \"top\": 520,\n" +
                    "        \"width\": 14\n" +
                    "      },\n" +
                    "      \"words\": \"6\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 21,\n" +
                    "        \"left\": 154,\n" +
                    "        \"top\": 556,\n" +
                    "        \"width\": 55\n" +
                    "      },\n" +
                    "      \"words\": \"其它\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 21,\n" +
                    "        \"left\": 24,\n" +
                    "        \"top\": 577,\n" +
                    "        \"width\": 85\n" +
                    "      },\n" +
                    "      \"words\": \"餐盒费:1\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 20,\n" +
                    "        \"left\": 22,\n" +
                    "        \"top\": 602,\n" +
                    "        \"width\": 87\n" +
                    "      },\n" +
                    "      \"words\": \"配送费:5\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 22,\n" +
                    "        \"left\": 227,\n" +
                    "        \"top\": 650,\n" +
                    "        \"width\": 95\n" +
                    "      },\n" +
                    "      \"words\": \"原价:￥25\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 41,\n" +
                    "        \"left\": 133,\n" +
                    "        \"top\": 671,\n" +
                    "        \"width\": 189\n" +
                    "      },\n" +
                    "      \"words\": \"总计:￥25\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 40,\n" +
                    "        \"left\": 24,\n" +
                    "        \"top\": 734,\n" +
                    "        \"width\": 295\n" +
                    "      },\n" +
                    "      \"words\": \"紫来大街小区(下\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 42,\n" +
                    "        \"left\": 23,\n" +
                    "        \"top\": 773,\n" +
                    "        \"width\": 262\n" +
                    "      },\n" +
                    "      \"words\": \"田新街一巷7号)\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 32,\n" +
                    "        \"left\": 27,\n" +
                    "        \"top\": 815,\n" +
                    "        \"width\": 56\n" +
                    "      },\n" +
                    "      \"words\": \"137\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 32,\n" +
                    "        \"left\": 173,\n" +
                    "        \"top\": 819,\n" +
                    "        \"width\": 53\n" +
                    "      },\n" +
                    "      \"words\": \"635\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 41,\n" +
                    "        \"left\": 26,\n" +
                    "        \"top\": 852,\n" +
                    "        \"width\": 146\n" +
                    "      },\n" +
                    "      \"words\": \"王(先生)\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"location\": {\n" +
                    "        \"height\": 15,\n" +
                    "        \"left\": 134,\n" +
                    "        \"top\": 910,\n" +
                    "        \"width\": 73\n" +
                    "      },\n" +
                    "      \"words\": \" MSTCHING\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"words_result_num\": 26\n" +
                    "}";
           JSONObject resultobject= JSON.parseObject(result);

        }
        //饿了么2
        //沃尔玛3
        //家乐福3
       return  Receipt.receipt(ocr);
    }
}
