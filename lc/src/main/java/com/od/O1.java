package com.od;

import java.util.Scanner;

/**
 * @date 2024/10/24 11:02 AM
 *
 * 题目0001-勾股数
 * 如果三个正整数A、B、C ，A² + B² = C² 则为勾股数，
 *
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，则称其为勾股数元组。
 *
 * 请求出给定 n ~ m 范围内所有的勾股数元组。
 */
public class O1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i=n;i<m;i++){
            for(int j=i+1;j<m;j++){
                double sqrt = Math.sqrt(i * i + j * j);
                double ctemp = (double) (int) sqrt;
                if(sqrt != ctemp){
                    continue;
                }
                int c = (int)ctemp;
                if(isP(i,c)&&isP(j,c)){
                    System.out.println(i+" "+j+" "+c);
                }
            }
        }
    }

    private static boolean isP(int a,int b){
        int amin = (int)Math.sqrt(a);
        int bmin = (int)Math.sqrt(b);
        int min = Math.min(amin, bmin);
        for(int i=2;i<=min;i++){
            if(a%i==0 && b%i==0){
                return false;
            }
        }
        return true;
    }
}
