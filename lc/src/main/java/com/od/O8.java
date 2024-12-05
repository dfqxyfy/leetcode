package com.od;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @date 2024/12/1 01:28
 */
public class O8 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String m = scanner.nextLine();
            int r = scanner.nextInt();
            solution(m, r);
        }
    }

    private static void solution(String m, int r) {
        String[] split = m.split(",");
        int[] res = new int[split.length];
        for(int i=0;i<split.length;i++){
            res[i] = Integer.valueOf(split[i]);
        }
        Arrays.sort(res);
        int maxValue =0;
        for(int i=0;i<split.length;i++){
            for(int k=i+1;k< split.length;k++){
                for(int l=k+1;l<split.length;l++){
                    int value = res[i]+res[k]+res[l];
                    if(value<=r){
                        maxValue = Math.max(maxValue,value);
                    }
                }
            }
        }
        System.out.println(maxValue);
    }

}
