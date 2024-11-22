package com.ccs.lc.stackandqueue;

/**
 * @date 2024/11/21 6:19 PM
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 s 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class L1047 {
    public String removeDuplicates(String s) {
        StringBuilder strb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean isRepeat = false;
        boolean needDel = false;
        for(int i=0;i<chars.length;i++){
            if(i>0 && chars[i-1] == chars[i] && needDel){
                if(strb.length()>0) {
                    strb.deleteCharAt(strb.length() - 1);
                }
                isRepeat = true;
                needDel = false;
            }else{
                strb.append(chars[i]);
                needDel = true;
            }
        }


        if(isRepeat){
            return removeDuplicates(strb.toString());
        }else{
            return strb.toString();
        }
    }


    public String removeDuplicates2(String s){
        StringBuilder strb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i>0){
                if(strb.length()>0 && s.charAt(i) == strb.charAt(strb.length()-1)){
                    strb.deleteCharAt(strb.length()-1);
                }else{
                    strb.append(s.charAt(i));
                }
            }else{
                strb.append(s.charAt(i));
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new L1047().removeDuplicates("abbaca"));
        System.out.println(new L1047().removeDuplicates("aaaaaaaaa"));
        System.out.println(new L1047().removeDuplicates("aababaab"));

        System.out.println(new L1047().removeDuplicates2("aaaaaaaaa"));
        System.out.println(new L1047().removeDuplicates2("aababaab"));
    }
}
