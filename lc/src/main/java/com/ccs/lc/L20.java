package com.ccs.lc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @date 2024/11/14 9:48 PM
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class L20 {
    public boolean isValid(String s) {


        Deque<Character> stack2 = new LinkedList<Character>();
        stack2.push('a');

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(s.charAt(i) == ')' ){
                    if(pop != '('){
                        return false;
                    }
                }
                if(s.charAt(i) == '}'){
                    if(pop != '{'){
                        return false;
                    }
                }
                if(s.charAt(i) == ']'){
                    if(pop != '['){
                        return false;
                    }
                }

            }
        }
        if(stack.empty()){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String s = "([])(";
        s=")";
        boolean valid = new L20().isValid(s);
        System.out.println(valid);
    }
}
