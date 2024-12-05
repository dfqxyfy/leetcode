package com.od;

import java.util.Scanner;

/**
 * @date 2024/12/4 11:09
 * 简易压缩算法
 * 题目描述
 * 有一种简易压缩算法：针对全部为小写英文字母组成的字符串，
 * 将其中连续超过两个相同字母的部分压缩为连续个数加该字母
 * 其他部分保持原样不变.
 * 例如字符串aaabbccccd 经过压缩变成字符串 3abb4cd
 * 请您编写解压函数,根据输入的字符串,
 * 判断其是否为合法压缩过的字符串
 * 若输入合法则输出解压缩后的字符串
 * 否则输出字符串!error来报告错误
 *
 * 输入描述
 * 输入一行，为一个ASCII字符串
 * 长度不超过100字符
 * 用例保证输出的字符串长度也不会超过100字符串
 */
public class O59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        System.out.println(change(s));
    }

    public static String change(String s){
        StringBuilder strb = new StringBuilder();
        StringBuilder numStrb= new StringBuilder();
        char ch ;
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                //验证方式包含两种 1. 数字之后必须是字母， 2，数字之后的字母不能重复， 3.不能有两个连续的字母

                //是
                if(numStrb.length()==0){
                    if(i+2<s.length() && s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2)){
                        return "!error";
                    }
                    strb.append(s.charAt(i));
                }
                if(numStrb.length()>0){
                    int num = Integer.valueOf(numStrb.toString());
                    if(num<=2){
                        return "!error";
                    }

                    if(i+1<s.length()){
                        if(s.charAt(i)==s.charAt(i+1) ){
                            return "!error";
                        }
                    }
                    for(int j=0;j<num;j++){
                        strb.append(s.charAt(i));
                    }
                }
                numStrb=new StringBuilder();
            }else if(Character.isDigit(s.charAt(i))){
                //验证方式包含两种 1. 数字之后必须是字母， 2，数字之后的字母不能重复， 3.不能有两个连续的字母
                numStrb.append(s.charAt(i));
            }else{
                return "!error";
            }
        }
        if(numStrb.length()>0){
            return "!error";
        }
        return strb.toString();
    }
}
