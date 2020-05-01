package com.zjw.ocr.model;

import lombok.Data;

import java.util.List;

@Data
public class BillInfo {
    //商店名称
    String shopName;
    //支付日期
    String payDate;
    //商品详情
    List<GoodoDetail> goodoDetail;
    //实付金额
    String payAmount;
    //总金额
    String totalAmount;
    //总数量
    Integer totalNum;
    //总数据
    String data;
    //图片类型是否正确
    boolean imgType=true;

}
