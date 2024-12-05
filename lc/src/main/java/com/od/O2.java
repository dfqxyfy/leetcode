package com.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @date 2024/10/24 11:33 AM
 * 题目0002-整数对最小和
 *
 * 给定两个整数数组 array1 array2
 * 数组元素按升序排列
 * 假设从array1 array2中分别取出一个元素可构成一对元素
 * 现在需要取出K个元素
 * 并对取出的所有元素求和
 * 计算和的最小值
 * 注意：
 * 两对元素如果对应于array1 array2中的两个下标均相同，则视为同一个元素
 *
 */
public class O2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m= scanner.nextLine();
        String n=scanner.nextLine();
        int k=scanner.nextInt();


        List<Integer> list1 = new ArrayList<>();
        String[] s = m.split(" ");
        for(int i=0;i<s.length;i++){
            list1.add(Integer.valueOf(s[i]));
        }
        List<Integer> list2 = new ArrayList<>();
        String[] s2 = n.split(" ");
        for(int i=0;i<s2.length;i++){
            list2.add(Integer.valueOf(s2[i]));
        }

        List<Integer> resList = new ArrayList<>();
        for(int i=1;i<list1.size();i++){
            for(int j=1;j<list2.size();j++){
                resList.add(list1.get(i)+list2.get(j));
            }
        }
        resList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Integer count = Integer.valueOf(k);
        int res=0;
        for(int i=0;i<count;i++ ){
            res+=resList.get(i);
        }
        System.out.println(res);
    }


}
