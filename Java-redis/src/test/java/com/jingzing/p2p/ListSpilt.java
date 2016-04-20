package com.jingzing.p2p;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis Wang on 2016/4/20.
 */

public class ListSpilt {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 23; i++){
            list.add(i);
        }
        int size = 23;
        int batchNum = 5;  //单个退款批次号对应的退款笔数，默认为每次50笔
        int count = size % batchNum > 0 ? size / batchNum + 1 : size / batchNum;    //要发起请求的次数
        int fromIndex = 0;
        int toIndex = 0;

        System.out.println("count: " + count);

        for(int i = 0; i < count; i++){
            fromIndex = i * batchNum;
            if(i == count - 1 && (size % batchNum != 0)){
                batchNum = size % batchNum;
                toIndex = size;

            }else{
                toIndex = (i + 1) * batchNum ;
            }
            System.out.println("fromIndex: " + fromIndex + " toIndex: " + toIndex + " batchNum: " + batchNum +" i: " + (i+1));
            System.out.println(list.subList(fromIndex, toIndex));
        }
    }
}
