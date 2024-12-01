package com.ccs.lc.yuanfudao;

import java.util.*;

/**
 * @date 2024/11/26 00:38
 *
 * 加减乘除 运算表达式
 *
 * (20+15)*15-200
 *
 * 1. 思路： 前缀表达式转成中缀表达式（逆波兰表达式）
 */
public class ExprExe {

    public int exec(String expr){

        Deque<String> stack = new LinkedList<>();
        stack.push("#");

        List<String> bolanExpr = new ArrayList<>();

        boolean isNum = false;
        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            String s = String.valueOf(ch);
            if(isOpt(s)){
                isNum = false;
                if( priority(s) > priority(stack.peek())){
                    stack.push(s);
                }else{
                    if(s == ")"){
                        stack.push(s);
                    }

                    while( priority(s) <= priority(stack.peek())) {
                        String pop = stack.pop();
                        if (!"(".equals(pop) && !")".equals(pop)) {
                            bolanExpr.add(pop);
                        }
                    }
                }

            }else{
                if(isNum){
                    bolanExpr.set(bolanExpr.size()-1, bolanExpr.get(bolanExpr.size()-1) +s);
                }else {
                    bolanExpr.add(s);
                }
                isNum = true;
            }
        }
        while(stack.size()>1){
            bolanExpr.add(String.valueOf(stack.pop()));
        }

        System.out.println(bolanExpr);

        return 0;

    }

    private boolean isOpt(String ch){
        return stringMap.containsKey(ch);
    }


    Map<String,Integer> stringMap = new HashMap<String,Integer> (){
        {
            put("#",0);

            put("+",1);
            put("-",1);

            put("*",2);
            put("/",2);

//            put("(",3);
//            put(")",3);
        }
    };
    private int priority(String opt){
        return stringMap.get(opt);
    }

    public static void main(String[] args) {
        new ExprExe().exec("6+(4+3)*6/2-7");
        //new ExprExe().exec("(20+15)*35-222");
    }

}
