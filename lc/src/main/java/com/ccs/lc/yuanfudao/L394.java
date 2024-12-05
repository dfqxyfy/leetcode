package com.ccs.lc.yuanfudao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/26 02:38
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 */
public class L394 {

    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        int cur = 0;
        while(cur<s.length()){
            StringBuilder strb = new StringBuilder();
            if(Character.isDigit(s.charAt(cur))){
                while(Character.isDigit(s.charAt(cur))) {
                    strb.append(String.valueOf(s.charAt(cur)));
                    cur++;
                }
                stack.push(strb.toString());
            }else if(s.charAt(cur) == '['){
                strb.append(String.valueOf(s.charAt(cur++)));
                stack.push(strb.toString());
            }else if(s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z' ){
                strb.append(String.valueOf(s.charAt(cur++)));
                stack.push(strb.toString());
            }else if(s.charAt(cur) == ']'){
                //String st = stack.pop();
                StringBuilder temp = new StringBuilder();
                while(isLetture(stack.peek())){
                    String pop = stack.pop();
                    temp.append(pop);
                }
                String left = stack.pop();
                String count = "1";
                if(!stack.isEmpty()&&isNumber(stack.peek())){
                    count = stack.pop();
                }

                Integer c = Integer.valueOf(count);
                StringBuilder needAdd = new StringBuilder();
                StringBuilder reverse = temp.reverse();
                for(int i=0;i<c;i++){
                    needAdd.append(reverse);
                }
                for(int i =0;i<needAdd.length();i++){
                    stack.push(String.valueOf(needAdd.charAt(i)));
                }
                cur++;
            }

        }
        StringBuilder res = new StringBuilder();
        while(stack.peek()!=null){
            res.append(stack.pop());
        }
        return res.reverse().toString();

    }


    private boolean isLetture(String s){
        if(s.length()==1){
            return Character.isLetter(s.charAt(0));
        }
        return false;
    }


    private boolean isNumber(String s){
        for(int i=0;i<s.length();i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //System.out.println(new L394().decodeString("3[a]2[bc]"));
        System.out.println(new L394().decodeString("2[a][bc]"));
    }
}
