package com.ccs.lc.yuanfudao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/25 23:15
 *
 * 套了很多箱子（[[]3]代表1个大箱子里放了3个小箱子共有4个箱子）
 *
 * [[[]2[]3]35]1
 */
public class PackNum {

    public int packs(String s){
        Deque<String> stack = new LinkedList<>();
        int cur = 0;

        while(cur<s.length()) {
            if (s.charAt(cur) == '[') {
                stack.push(String.valueOf(s.charAt(cur)));
                cur++;
            } else if (s.charAt(cur) == ']') {
                StringBuilder nums = new StringBuilder();
                cur++;
                if(cur < s.length()  && Character.isDigit(s.charAt(cur))) {
                    while (cur < s.length() - 1 && Character.isDigit(s.charAt(cur))) {
                        nums.append(s.charAt(cur ));
                        cur++;
                    }
                }

                Integer num = 1;
                if(isNumber(nums.toString())) {
                    num = Integer.valueOf(nums.toString());
                }
                Integer innerNum = 1;
                // [[2[]2]
                if ("[".equals(stack.peek())) {
                    innerNum = 1;
                    stack.pop();

                } else if(isNumber(stack.peek())){
                    String pop = stack.pop();
                    innerNum = Integer.valueOf(pop);
                    if("[".equals(stack.peek())){
                        stack.pop();
                    }
                }
                if(isNumber(stack.peek())){
                    String pop = stack.pop();
                    Integer existVal = Integer.valueOf(pop);
                    innerNum = innerNum + existVal;
                }

                stack.push(String.valueOf(num*innerNum));
            }
        }
        Integer res = Integer.valueOf(stack.pop());
        return res;
    }

    public boolean isNumber(String s){
        if(s==null||s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int packs = new PackNum().packs("[[]3]4");
        System.out.println(packs);
    }
}
