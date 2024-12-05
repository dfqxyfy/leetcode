package com.ccs.lc.str;

/**
 * @date 2024/11/20 11:40 PM
 */
public class L344 {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(end > start){
            char temp = s[start];
            s[start]=s[end];
            s[end]=temp;
            end --;
            start++;
        }

    }

    public static void main(String[] args) {
        char[] s = "abcde".toCharArray();
        new L344().reverseString(s);
        System.out.println(s);
    }
}
