package com.ccs.lc.str;

import com.ccs.MyUtil;

/**
 * @date 2024/11/20 11:46 PM
 */
public class L541 {
    public String reverseString(String s,int k) {

        int i=0;
        StringBuilder strb = new StringBuilder();
        while(i<s.length()/(2*k)+1){
            System.out.println(i);
            if(2*i*k<=s.length()-1) {
                int end = (2*i+1)*k < s.length()?(2*i+1)*k:s.length()-1;
                int start = 2*i*k;
                //MyUtil.log(start,end);
                for(int j=end-1;j>=start;j--) {
                    strb.append(s.charAt(j));
                }
                //MyUtil.log(strb.toString());
            }else{
                break;
            }
            if((2*i+1)*k<=s.length()-1){
                int start = (2*i+1)*k;
                int end = (2*i+2)*k<s.length()?(2*i+2)*k:s.length();
                //MyUtil.log(start,end);
                strb.append(s.substring(start,end));
                //MyUtil.log(strb.toString());
            }else{
                break;
            }
            i++;

        }

        s = strb.toString();
        //System.out.println(s);
        return s;
    }

    public String reverseString2(String s,int k){
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i+=2*k){
            int left = i;
            int right = Math.min(i+k,chars.length)-1;

            while(right<left){
                char temp = chars[left] ;
                chars[left] = chars[right];
                chars[right] = temp;
                right--;
                left++;
            }

        }
        return new String(chars);


    }

    public static void main(String[] args) {
        new L541().reverseString("abcdefg",2);
        new L541().reverseString2("abcdefg",2);
    }
}
