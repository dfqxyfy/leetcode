package com.ccs.lc.str;

/**
 * @date 2024/11/21 11:35 AM
 *
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 *
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 * 思路：先全部反转，然后部分反转 前n个， 翻转后length-n个
 *
 */
public class K55 {
    public String reverseRight(String s,int n){
        char[] chars = s.toCharArray();
        reverse(chars,0,s.length()-1);

        reverse(chars,0,n-1);

        reverse(chars,n,s.length()-1);

        return new String(chars);

    }

    public void reverse(char[] chars,int left,int right){
        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new K55().reverseRight("123456",2));
    }
}
