package com.ccs.nc;

import java.util.*;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop(); 
    
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        solution.push(1);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}