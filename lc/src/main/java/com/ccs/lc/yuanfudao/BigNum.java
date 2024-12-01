package com.ccs.lc.yuanfudao;

import java.util.Arrays;

/**
 * @date 2024/11/25 7:03 PM
 *
 * 两个大数相乘
 */
public class BigNum {

    public String twoNum(String num1,String num2){
        int[] array1 = new int[num1.length()];
        int[] array2 = new int[num2.length()];

        int[] result = new int[num1.length()+num2.length()];

        for(int i=0;i<num1.length();i++){
            array1[i] = num1.charAt(num1.length()-1-i)-'0';
        }
        for(int i=0;i<num2.length();i++){
            array2[i] = num2.charAt(num2.length()-1-i)-'0';
        }

        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array2.length;j++){
                result[i+j] += array1[i]*array2[j];
            }
        }

        int add = 0;
        for(int i=0;i< result.length;i++){
            int num = result[i] + add;
            add = num /10;
            result[i] = num%10;
        }
        StringBuilder strb = new StringBuilder();
        boolean prexisZero = true;
        for(int i=result.length-1;i>=0;i--){
            if(result[i]!=0){
                prexisZero = false;
            }
            if(!prexisZero) {
                strb.append(result[i]);
            }
        }   
        return strb.toString();

    }

    public static void main(String[] args) {
        String s = new BigNum().twoNum("123", "567");
        System.out.println(s);
    }
}
