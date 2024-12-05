package com.ccs.lc.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/21 10:10 PM
 *  逆波兰表达式求值
 */
public class L150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for(int i=0;i<tokens.length;i++){
            if(isNumber(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                Integer count = 0;
                switch (tokens[i]){
                    case "+":
                        count = n1+n2;
                        break;
                    case "-":
                        count = n2-n1;
                        break;
                    case "*":
                        count = n1*n2;
                        break;
                    case "/":
                        count = n2/n1;
                        break;
                }
                stack.push(count);
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String t){
        if("+".equals(t)||"-".equals(t)||"*".equals(t)||"/".equals(t)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] nums = new String[]{"2","1","+","3","*"};
        System.out.println(new L150().evalRPN(nums));
        nums = new String[]{"4","13","5","/","+"};
        System.out.println(new L150().evalRPN(nums));


    }
}
