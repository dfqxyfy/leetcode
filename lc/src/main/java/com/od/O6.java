package com.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @date 2024/10/24 2:05 PM
 *
 * 小明今年升学到了小学一年级，
 * 来到新班级后，发现其他小朋友身高参差不齐，
 * 然后就想基于各小朋友和自己的身高差，对他们进行排序，
 * 请帮他实现排序
 * 输出排序结果，各正整数以空格分割
 * 和小明身高差绝对值最小的小朋友排在前面
 * 和小明身高差绝对值最大的小朋友排在后面
 * 如果两个小朋友和小明身高差一样
 * 则个子较小的小朋友排在前面
 *
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 *
 * 99 101 98 102 97 103 96 104 95 105
 *
 */
public class O6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xiaoming = scanner.nextInt();
        int nums = scanner.nextInt();
        //int[] students = new int[nums];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums;i++){
            list.add(scanner.nextInt()) ;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = Math.abs(o1-xiaoming) - Math.abs(o2-xiaoming);
                if(res == 0){
                    return o1-o2;
                }
                return res;
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }


    }
}
