package com.od;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @date 2024/10/24 2:23 PM
 *
 * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植 N 棵胡杨（编号1-  N ），排成一排。
 * 一个月后，有 M 棵胡杨未能成活。
 * 现可补种胡杨 K 棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
 *
 * 5
 * 2
 * 2 4
 * 1
 */
public class L256 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int deathNum = scanner.nextInt();
        Set<Integer> sets = new HashSet<>();
        int[] deathArr = new int[deathNum];
        for(int i=0;i<deathNum;i++){
            deathArr[i] = scanner.nextInt();
            sets.add(deathArr[i]);
        }
        int k = scanner.nextInt();

        int start = 1;
        int maxTree = 0;

        //从0处开始算

        //从 deathArr处开始算
        int count = 0;
        int temp = k;
        int maxLen = 0;
        for(int i=1;i<=total;i++) {
            if(sets.contains(i)) {
                temp--;
                if(temp>=0){
                    count++;
                }else{
                    break;
                }
            }else{
                count++;
            }
        }
        maxLen = Math.max(maxLen,count);
        for(int i=0;i<deathArr.length;i++){
            temp = k;
            count = 0;
            for(int j=deathArr[0]+1;j<=total;j++){
                if(sets.contains(j)){
                    temp--;
                    if(temp>=0){
                        count++;
                    }else{
                        break;
                    }
                }else{
                    count++;
                }
            }
            maxLen = Math.max(maxLen,count);
        }


        System.out.println(maxLen);
    }
}
