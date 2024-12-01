package com.ccs.lc.yuanfudao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/26 20:33
 */
public class L394_2 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        int cur = 0;
        while(cur<s.length()) {
            if(Character.isDigit(s.charAt(cur))){
                StringBuilder strb = new StringBuilder();
                while(Character.isDigit(s.charAt(cur))){
                    strb.append(s.charAt(cur++));
                }
                stack.push(strb.toString());
            }else if('[' == s.charAt(cur)){
                stack.push(String.valueOf(s.charAt(cur++)));
            }else if(Character.isLetter(s.charAt(cur))){
                stack.push(String.valueOf(s.charAt(cur++)));
            }else if(']'==s.charAt(cur++)){
                StringBuilder strb = new StringBuilder();
                while(!stack.isEmpty()&&!"[".equals(stack.peek())){
                    String pop = stack.pop();
                    strb.append(pop);
                }
                stack.pop();
                int count = 1;
                if(isNum(stack.peek())){
                    count = Integer.valueOf(stack.pop());
                }
                StringBuilder stb = new StringBuilder();
                StringBuilder reverse = strb.reverse();
                for(int i=0;i<count;i++) {
                    stb.append(reverse);
                }
                stack.push(stb.toString());
            }

        }
        StringBuilder strb = new StringBuilder();
        while(stack.peek()!=null){
            strb = new StringBuilder(stack.pop()).append(strb);
        }
        return strb.toString();
    }

    private boolean isNum(String s){
        if(s==null || s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) < '0' ||s.charAt(i) >'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L394_2().decodeString("3[a]2[bc]"));;
    }
}
