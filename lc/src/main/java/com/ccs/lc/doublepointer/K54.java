package com.ccs.lc.doublepointer;

/**
 * @date 2024/11/21 12:59 PM
 */
public class K54 {

    public String replace(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] >= '0' && chars[i] <='9'){
                count++;
            }
        }
        int num = "number".length();
        int newLength = s.length() + count * (num-1);
        char[] res = new char[newLength];
        int c = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] >='0' && chars[i] <= '9'){
                res[c++]='n';
                res[c++]='u';
                res[c++]='m';
                res[c++]='b';
                res[c++]='e';
                res[c++]='r';
            }else{
                res[c++] = chars[i];
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new K54().replace("a1b2c3"));
    }
}
