package com.zjw.ocr.model;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArraySplit {

    /**
     * @param args
     *
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] ary = {0,1,2,3,4,5};//要分割的数组
        int splitSize = 3;//分割的块大小
        Object[] subAry = splitAry(ary, splitSize);//分割后的子块数组

        for(Object obj: subAry){//打印输出结果
            int[] aryItem = (int[]) obj;
            for(int i = 0; i < aryItem.length; i++){
                System.out.print(aryItem[i] + ", ");
            }
            System.out.println();
        }
        List<JSONObject> messagesList=new ArrayList<>();
        for (int i=0;i<6;i++) {
            JSONObject obj=new JSONObject();
            messagesList.add(obj);
        }

        List<List<JSONObject>> list=splitList(messagesList,3);
        System.out.println("===="+list.size());
    }

    /**
     * splitAry方法<br>
     * @param ary 要分割的数组
     * @param subSize 分割的块大小
     * @return
     *
     */
    public static Object[] splitAry(int[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize: ary.length / subSize + 1;

        List<List<Integer>> subAryList = new ArrayList<List<Integer>>();

        for (int i = 0; i < count; i++) {
            int index = i * subSize;
            List<Integer> list = new ArrayList<Integer>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }

        Object[] subAry = new Object[subAryList.size()];

        for(int i = 0; i < subAryList.size(); i++){
            List<Integer> subList = subAryList.get(i);
            int[] subAryItem = new int[subList.size()];
            for(int j = 0; j < subList.size(); j++){
                subAryItem[j] = subList.get(j).intValue();
            }
            subAry[i] = subAryItem;
        }

        return subAry;
    }
    public static List<List<JSONObject>> splitList(List<JSONObject> messagesList, int groupSize) {
        int length = messagesList.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize; // TODO
        List<List<JSONObject>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i + 1) * groupSize < length ? (i + 1) * groupSize : length;
            newList.add(messagesList.subList(fromIndex, toIndex));
        }
        return newList;
    }

}