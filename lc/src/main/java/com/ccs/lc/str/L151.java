package com.ccs.lc.str;

/**
 * @date 2024/11/21 10:53 AM
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class L151 {
    public String reverseWord(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        reversWord(chars,left,right);

        left = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ' ' ){
                right = i-1;
                left = i+1;
            }
            if(i==chars.length-1){
                right = i;
            }
            reversWord(chars,left,right);
        }

        return new String(chars);
    }

    private void reversWord(char[] chars,int left,int right){
        while(left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L151().reverseWord("the sky is blue"));;
    }
}
