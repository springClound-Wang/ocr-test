package com.zjw.ocr.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjw.ocr.model.ArraySplit;
import com.zjw.ocr.model.BillInfo;
import com.zjw.ocr.model.GoodoDetail;
import com.zjw.ocr.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public String upFile(@RequestParam("ocr")MultipartFile ocr,@RequestParam("type") Integer type){
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
           JSONObject resultObject= JSON.parseObject(result);
            JSONArray arrayResult= resultObject.getJSONArray("words_result");
            BillInfo billInfo=new BillInfo();
            List<GoodoDetail> goodoDetail =new ArrayList<>();
            List<JSONObject> jSONObjectList =new ArrayList<>();
            for(int i=0;i<arrayResult.size();i++){
              JSONObject jsonObject=  arrayResult.getJSONObject(i);

                if(i==0){
                    billInfo.setPayDate(jsonObject.getString("words"));
                }
                if(i==2){
                    billInfo.setShopName(jsonObject.getString("words"));
                }
                String wordsStr=jsonObject.getString("words");
                if(wordsStr.indexOf("原价")!=-1){
                    billInfo.setTotalAmount(wordsStr.substring(3,6));
                }
                if(wordsStr.indexOf("总计")!=-1){
                    billInfo.setPayAmount(wordsStr.substring(3,6));
                }

                //找商品详情
                if(wordsStr.contains("口袋")){
                    int index=i+1;
                    for(int j=index;j<arrayResult.size();j++) {
                        JSONObject jsonIndex = arrayResult.getJSONObject(j);
                        String ortherWords=  jsonIndex.getString("words");
                        if(ortherWords.indexOf("其它")!=-1){
                            break;
                        }
                        jSONObjectList.add(jsonIndex);

                    }
                }
            }
            List<List<JSONObject>> messagesList=ArraySplit.splitList(jSONObjectList,3);
            for (int i=0;i<messagesList.size();i++){
                List<JSONObject> objectDataList=messagesList.get(i);
                GoodoDetail goodoDet=new GoodoDetail();
                for (int j=0;j<objectDataList.size();j++){
                    String words=objectDataList.get(j).getString("words");
                    if(j==0){
                        goodoDet.setGoodsName(words);
                    }else
                    if(j==1){
                        goodoDet.setNumber(words.substring(1,2));
                    }else
                    if(j==2){
                        goodoDet.setAmount(words);
                    }
                }
                goodoDetail.add(goodoDet);
            }
            billInfo.setTotalNum(goodoDetail.size());
            billInfo.setGoodoDetail(goodoDetail);
            return  JSON.toJSONString(billInfo);
        }
        //饿了么2
        else if(type==2){
            String result="{\"log_id\": 3588465884264690553, \"words_result_num\": 17, \"words_result\": [{\"location\": {\"width\": 222, \"top\": 0, \"left\": 95, \"height\": 48}, \"words\": \"#24饿了么\"}, {\"location\": {\"width\": 217, \"top\": 65, \"left\": 99, \"height\": 26}, \"words\": \"*米多面多(宜山路店)\"}, {\"location\": {\"width\": 301, \"top\": 112, \"left\": 51, \"height\": 48}, \"words\": \"--已在线支付-\"}, {\"location\": {\"width\": 243, \"top\": 205, \"left\": 32, \"height\": 25}, \"words\": \"期望送达时间:立即配送\"}, {\"location\": {\"width\": 321, \"top\": 225, \"left\": 33, \"height\": 34}, \"words\": \"下单时间:2020-04-2311:18:47\"}, {\"location\": {\"width\": 326, \"top\": 252, \"left\": 29, \"height\": 30}, \"words\": \"订单编号:3062701954571429103\"}, {\"location\": {\"width\": 289, \"top\": 283, \"left\": 102, \"height\": 22}, \"words\": \"------号-篮子-----\"}, {\"location\": {\"width\": 272, \"top\": 309, \"left\": 26, \"height\": 48}, \"words\": \"豆角焖面+蛋花汤+秘制丸子\"}, {\"location\": {\"width\": 118, \"top\": 349, \"left\": 281, \"height\": 48}, \"words\": \"145.88\"}, {\"location\": {\"width\": 208, \"top\": 422, \"left\": 24, \"height\": 30}, \"words\": \"[单品折扣:-13.76]\"}, {\"location\": {\"width\": 184, \"top\": 452, \"left\": 40, \"height\": 25}, \"words\": \"首次光顾立减:-1\"}, {\"location\": {\"width\": 255, \"top\": 478, \"left\": 23, \"height\": 27}, \"words\": \"[超级会员专享红包:-4]\"}, {\"location\": {\"width\": 130, \"top\": 534, \"left\": 24, \"height\": 26}, \"words\": \"餐盒费:￥2\"}, {\"location\": {\"width\": 154, \"top\": 563, \"left\": 22, \"height\": 25}, \"words\": \"配送费:￥0.8\"}, {\"location\": {\"width\": 154, \"top\": 589, \"left\": 22, \"height\": 29}, \"words\": \"原价:￥48.68\"}, {\"location\": {\"width\": 302, \"top\": 615, \"left\": 22, \"height\": 57}, \"words\": \"实付:￥29.92\"}, {\"location\": {\"width\": 340, \"top\": 724, \"left\": 28, \"height\": 73}, \"words\": \"191267754,19\"}]}";
            JSONObject resultObject= JSON.parseObject(result);
            JSONArray arrayResult= resultObject.getJSONArray("words_result");
            BillInfo billInfo=new BillInfo();
            List<GoodoDetail> goodoDetail =new ArrayList<>();
            List<JSONObject> jSONObjectList =new ArrayList<>();
            for(int i=0;i<arrayResult.size();i++) {
                JSONObject jsonObject = arrayResult.getJSONObject(i);
                String wordsStr=jsonObject.getString("words");
                if(i==1){
                    billInfo.setShopName(wordsStr);
                }
                if(i==4){
                    String str=wordsStr.substring(5,wordsStr.length());
                    billInfo.setPayDate(str.substring(0,10)+" "+str.substring(10,str.length()));
                }
                if(wordsStr.indexOf("原价")!=-1){
                    billInfo.setTotalAmount(wordsStr.substring(3,wordsStr.length()));
                }
                if(wordsStr.indexOf("实付")!=-1){
                    billInfo.setPayAmount(wordsStr.substring(3,wordsStr.length()));
                }
                //找商品详情
                if(i==7){
                    GoodoDetail goodoDet=new GoodoDetail();
                    goodoDet.setGoodsName(wordsStr);
                    int index=i+1;
                    wordsStr= arrayResult.getJSONObject(index).getString("words");
                    goodoDet.setNumber(wordsStr.substring(0,1));
                    goodoDet.setAmount(wordsStr.substring(1,wordsStr.length()));
                    goodoDetail.add(goodoDet);
                }
            }
            billInfo.setTotalNum(goodoDetail.size());
            billInfo.setGoodoDetail(goodoDetail);
            return  JSON.toJSONString(billInfo);
        }
        //优衣库3
        else if(type ==3){
            String result="{\"log_id\": 991663240474048921, \"words_result_num\": 34, \"words_result\": [{\"location\": {\"width\": 139, \"top\": 0, \"left\": 396, \"height\": 52}, \"words\": \" QLO\"}, {\"location\": {\"width\": 115, \"top\": 78, \"left\": 407, \"height\": 40}, \"words\": \"优衣库\"}, {\"location\": {\"width\": 394, \"top\": 151, \"left\": 191, \"height\": 44}, \"words\": \"商店名称:上海虹桥天地优衣库店\"}, {\"location\": {\"width\": 386, \"top\": 183, \"left\": 188, \"height\": 40}, \"words\": \"地址:上海市闵行区申长路688号\"}, {\"location\": {\"width\": 131, \"top\": 217, \"left\": 265, \"height\": 30}, \"words\": \"虹桥天地2F\"}, {\"location\": {\"width\": 239, \"top\": 248, \"left\": 184, \"height\": 36}, \"words\": \"电话:021-61679509\"}, {\"location\": {\"width\": 353, \"top\": 285, \"left\": 183, \"height\": 28}, \"words\": \"欢迎登陆官网wwn. unig lo.com\"}, {\"location\": {\"width\": 67, \"top\": 318, \"left\": 208, \"height\": 29}, \"words\": \"顾客\"}, {\"location\": {\"width\": 180, \"top\": 313, \"left\": 398, \"height\": 23}, \"words\": \"703******1841\"}, {\"location\": {\"width\": 313, \"top\": 371, \"left\": 187, \"height\": 45}, \"words\": \"2000140521906×1R\"}, {\"location\": {\"width\": 100, \"top\": 371, \"left\": 639, \"height\": 31}, \"words\": \"99.00T\"}, {\"location\": {\"width\": 191, \"top\": 409, \"left\": 181, \"height\": 47}, \"words\": \"圆领T恤(短袖)\"}, {\"location\": {\"width\": 320, \"top\": 475, \"left\": 185, \"height\": 51}, \"words\": \"2000140522705×1R\"}, {\"location\": {\"width\": 105, \"top\": 470, \"left\": 648, \"height\": 32}, \"words\": \"99.00\"}, {\"location\": {\"width\": 195, \"top\": 518, \"left\": 178, \"height\": 50}, \"words\": \"圆领T恤(短袖)\"}, {\"location\": {\"width\": 330, \"top\": 588, \"left\": 182, \"height\": 58}, \"words\": \"2000139718119×1R\"}, {\"location\": {\"width\": 128, \"top\": 574, \"left\": 637, \"height\": 42}, \"words\": \"149.00\"}, {\"location\": {\"width\": 211, \"top\": 636, \"left\": 183, \"height\": 54}, \"words\": \"棉质松紧九分裤\"}, {\"location\": {\"width\": 317, \"top\": 714, \"left\": 199, \"height\": 52}, \"words\": \"20001315036761R\"}, {\"location\": {\"width\": 131, \"top\": 696, \"left\": 642, \"height\": 41}, \"words\": \"19.00T\"}, {\"location\": {\"width\": 356, \"top\": 751, \"left\": 198, \"height\": 58}, \"words\": \"优质长绒棉条纹衬衫(长袖)\"}, {\"location\": {\"width\": 74, \"top\": 848, \"left\": 209, \"height\": 33}, \"words\": \" Total\"}, {\"location\": {\"width\": 94, \"top\": 828, \"left\": 653, \"height\": 34}, \"words\": \"496.00\"}, {\"location\": {\"width\": 44, \"top\": 953, \"left\": 485, \"height\": 31}, \"words\": \" RME\"}, {\"location\": {\"width\": 89, \"top\": 946, \"left\": 662, \"height\": 30}, \"words\": \"496.00\"}, {\"location\": {\"width\": 88, \"top\": 968, \"left\": 216, \"height\": 34}, \"words\": \" Alipay\"}, {\"location\": {\"width\": 556, \"top\": 977, \"left\": 233, \"height\": 65}, \"words\": \"交易号:2020041722001447951414982709\"}, {\"location\": {\"width\": 557, \"top\": 1015, \"left\": 235, \"height\": 69}, \"words\": \"订单号:1305420301012220200417210526\"}, {\"location\": {\"width\": 208, \"top\": 1076, \"left\": 237, \"height\": 48}, \"words\": \"商家优惠:0.00\"}, {\"location\": {\"width\": 202, \"top\": 1120, \"left\": 243, \"height\": 41}, \"words\": \"平台优惠:0.00\"}, {\"location\": {\"width\": 598, \"top\": 1248, \"left\": 235, \"height\": 84}, \"words\": \"日期时间店铺P0S员工交易号\"}, {\"location\": {\"width\": 567, \"top\": 1326, \"left\": 241, \"height\": 80}, \"words\": \"1/04/202021:0554231326563122\"}, {\"location\": {\"width\": 251, \"top\": 1395, \"left\": 246, \"height\": 36}, \"words\": \" You were served by\"}, {\"location\": {\"width\": 133, \"top\": 1376, \"left\": 617, \"height\": 37}, \"words\": \" CHEN PING\"}]}";
            JSONObject resultObject= JSON.parseObject(result);
            JSONArray arrayResult= resultObject.getJSONArray("words_result");
            BillInfo billInfo=new BillInfo();
            List<GoodoDetail> goodoDetail =new ArrayList<>();
            List<JSONObject> jSONObjectList =new ArrayList<>();
            for(int i=0;i<arrayResult.size();i++) {
                JSONObject jsonObject = arrayResult.getJSONObject(i);
                String wordsStr=jsonObject.getString("words");
                if(i==2){
                    billInfo.setShopName(wordsStr.substring(5,wordsStr.length()));
                }
                if(wordsStr.contains("订单号")){
                    String str=wordsStr.substring(18,wordsStr.length());
                    billInfo.setPayDate(str.substring(0,4)+"/"+str.substring(4,6)+"/"+str.substring(6,8)+" "+str.substring(8,10)+":"+
                            str.substring(10,12)+":"+str.substring(12,14));
                }
                if(wordsStr.contains("Total")){
                    int index=i+1;
                    String amount=arrayResult.getJSONObject(index).getString("words");
                    billInfo.setTotalAmount(amount);
                    billInfo.setPayAmount(amount);
                }
                if(wordsStr.contains("顾客")){
                    int index=i+2;
                    for(int j=index;j<arrayResult.size();j++) {
                        JSONObject jsonIndex = arrayResult.getJSONObject(j);
                        String ortherWords=  jsonIndex.getString("words");
                        if(ortherWords.indexOf("Total")!=-1){
                            break;
                        }
                        jSONObjectList.add(jsonIndex);

                    }
                }

            }
            List<List<JSONObject>> messagesList=ArraySplit.splitList(jSONObjectList,3);
            for (int i=0;i<messagesList.size();i++){
                List<JSONObject> objectDataList=messagesList.get(i);
                GoodoDetail goodoDet=new GoodoDetail();
                for (int j=0;j<objectDataList.size();j++){
                    String words=objectDataList.get(j).getString("words");
                    if(j==2){
                        goodoDet.setGoodsName(words);
                    }else
                    if(j==0){
                        goodoDet.setNumber(words.substring(words.length()-2,words.length()).replaceAll("R",""));
                    }else
                    if(j==1){
                        goodoDet.setAmount(words.replaceAll("T",""));
                    }
                }
                goodoDetail.add(goodoDet);
            }
            billInfo.setTotalNum(goodoDetail.size());
            billInfo.setGoodoDetail(goodoDetail);
            return  JSON.toJSONString(billInfo);
        }
        //永辉4
        else if(type==4){
            String result="{\"log_id\": 4822312228881522169, \"words_result_num\": 33, \"words_result\": [{\"location\": {\"width\": 136, \"top\": 8, \"left\": 91, \"height\": 18}, \"words\": \"欢迎光临辉超市\"}, {\"location\": {\"width\": 118, \"top\": 28, \"left\": 99, \"height\": 18}, \"words\": \"朝阳区太阳宫店\"}, {\"location\": {\"width\": 275, \"top\": 68, \"left\": 21, \"height\": 21}, \"words\": \"店号:93222018/10/2315:40:20\"}, {\"location\": {\"width\": 262, \"top\": 89, \"left\": 23, \"height\": 20}, \"words\": \"收银机号:TY23小票号:03975633\"}, {\"location\": {\"width\": 264, \"top\": 110, \"left\": 22, \"height\": 20}, \"words\": \"收银员:80685646类型:零售销售\"}, {\"location\": {\"width\": 271, \"top\": 132, \"left\": 23, \"height\": 20}, \"words\": \"商品名称数量单价成交价\"}, {\"location\": {\"width\": 94, \"top\": 174, \"left\": 24, \"height\": 19}, \"words\": \"[2]卤水豆腐\"}, {\"location\": {\"width\": 128, \"top\": 196, \"left\": 24, \"height\": 17}, \"words\": \"23067170026021\"}, {\"location\": {\"width\": 37, \"top\": 195, \"left\": 256, \"height\": 19}, \"words\": \"2.60\"}, {\"location\": {\"width\": 59, \"top\": 216, \"left\": 28, \"height\": 19}, \"words\": \"]油菜\"}, {\"location\": {\"width\": 127, \"top\": 237, \"left\": 24, \"height\": 17}, \"words\": \"23000340015551\"}, {\"location\": {\"width\": 36, \"top\": 236, \"left\": 257, \"height\": 19}, \"words\": \"1.55\"}, {\"location\": {\"width\": 93, \"top\": 257, \"left\": 33, \"height\": 20}, \"words\": \"*2]瑞嘉猪肘\"}, {\"location\": {\"width\": 126, \"top\": 279, \"left\": 25, \"height\": 17}, \"words\": \"23073990397331\"}, {\"location\": {\"width\": 45, \"top\": 278, \"left\": 250, \"height\": 19}, \"words\": \"39.73\"}, {\"location\": {\"width\": 108, \"top\": 298, \"left\": 29, \"height\": 20}, \"words\": \"[z]白梨(二级)\"}, {\"location\": {\"width\": 124, \"top\": 320, \"left\": 29, \"height\": 17}, \"words\": \"23014600032271\"}, {\"location\": {\"width\": 36, \"top\": 321, \"left\": 257, \"height\": 17}, \"words\": \"3.22\"}, {\"location\": {\"width\": 120, \"top\": 343, \"left\": 29, \"height\": 12}, \"words\": \"===\"}, {\"location\": {\"width\": 43, \"top\": 359, \"left\": 26, \"height\": 19}, \"words\": \"应收\"}, {\"location\": {\"width\": 126, \"top\": 360, \"left\": 126, \"height\": 18}, \"words\": \"47.10件数:4\"}, {\"location\": {\"width\": 248, \"top\": 379, \"left\": 28, \"height\": 20}, \"words\": \"实收:47.10找零:0.00\"}, {\"location\": {\"width\": 67, \"top\": 419, \"left\": 28, \"height\": 18}, \"words\": \"微信支付\"}, {\"location\": {\"width\": 39, \"top\": 421, \"left\": 245, \"height\": 16}, \"words\": \"47.10\"}, {\"location\": {\"width\": 124, \"top\": 438, \"left\": 28, \"height\": 17}, \"words\": \"实际扣款:47.10\"}, {\"location\": {\"width\": 62, \"top\": 458, \"left\": 27, \"height\": 17}, \"words\": \"订单号:\"}, {\"location\": {\"width\": 236, \"top\": 478, \"left\": 27, \"height\": 21}, \"words\": \"6521100002201810231253911704\"}, {\"location\": {\"width\": 165, \"top\": 500, \"left\": 27, \"height\": 18}, \"words\": \"会员帐号:1-19200846\"}, {\"location\": {\"width\": 184, \"top\": 520, \"left\": 68, \"height\": 18}, \"words\": \"客服电话:010-84241299\"}, {\"location\": {\"width\": 266, \"top\": 537, \"left\": 28, \"height\": 25}, \"words\": \"请当面清点所购商品和找零,并保管\"}, {\"location\": {\"width\": 267, \"top\": 555, \"left\": 26, \"height\": 29}, \"words\": \"好收银小票以做开发票,退换货凭证\"}, {\"location\": {\"width\": 237, \"top\": 576, \"left\": 40, \"height\": 30}, \"words\": \"请至服务台索取分币,谢谢惠顾\"}, {\"location\": {\"width\": 238, \"top\": 596, \"left\": 21, \"height\": 32}, \"words\": \"积分查询请登录www. yonghui.cn\"}]}";
            JSONObject resultObject= JSON.parseObject(result);
            JSONArray arrayResult= resultObject.getJSONArray("words_result");
            BillInfo billInfo=new BillInfo();
            List<GoodoDetail> goodoDetail =new ArrayList<>();
            List<JSONObject> jSONObjectList =new ArrayList<>();
            for(int i=0;i<arrayResult.size();i++) {
                JSONObject jsonObject = arrayResult.getJSONObject(i);
                String wordsStr = jsonObject.getString("words");
                if (i == 2) {
                    String payDate=wordsStr.substring(7,wordsStr.length());
                    billInfo.setPayDate(payDate.substring(0,10)+" "+payDate.substring(10,payDate.length()));
                }
                if (i == 1) {
                    billInfo.setShopName(wordsStr);
                }

                if (wordsStr.indexOf("应收") != -1) {
                    int index=i+1;
                    String resultWords = arrayResult.getJSONObject(index).getString("words");
                    billInfo.setTotalAmount(resultWords.substring(0, 5));
                }
                if (wordsStr.indexOf("实收") != -1) {
                    billInfo.setPayAmount(wordsStr.substring(3, 8));
                }

                if (wordsStr.indexOf("商品名称数量单价成交价") != -1) {
                    int index=i+1;
                    for(int j=index;j<arrayResult.size();j++) {
                        JSONObject jsonIndex = arrayResult.getJSONObject(j);
                        String ortherWords=  jsonIndex.getString("words");
                        if(ortherWords.indexOf("===")!=-1){
                            break;
                        }
                        jSONObjectList.add(jsonIndex);

                    }
                }

            }
            List<List<JSONObject>> messagesList=ArraySplit.splitList(jSONObjectList,3);
            for (int i=0;i<messagesList.size();i++){
                List<JSONObject> objectDataList=messagesList.get(i);
                GoodoDetail goodoDet=new GoodoDetail();
                for (int j=0;j<objectDataList.size();j++){
                    String words=objectDataList.get(j).getString("words");
                    if(j==0){
                        goodoDet.setGoodsName(words);
                    }else
                    if(j==1){
                        goodoDet.setNumber(words.substring(words.length()-1,words.length()));
                    }else
                    if(j==2){
                        goodoDet.setAmount(words);
                    }
                }
                goodoDetail.add(goodoDet);
            }
            billInfo.setTotalNum(goodoDetail.size());
            billInfo.setGoodoDetail(goodoDetail);
            return  JSON.toJSONString(billInfo);
        }

        else{
            return "参数有误";
        }
       //return  Receipt.receipt(ocr);

    }

    public static void main(String[] args) {
        String str="订单号:1305420301012220200417210526";
        System.out.println("=="+str.substring(18,str.length()));
    }
}
