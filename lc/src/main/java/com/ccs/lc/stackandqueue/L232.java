package com.ccs.lc.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/21 5:02 PM
 * 用栈实现队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 */
public class L232 {
    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();


    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if(stack2.isEmpty()&& stack1.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if(stack2.isEmpty()&& stack1.isEmpty()){
            return -1;
        }
        return stack2.peek();
    }

    public boolean empty() {
        if(stack2.isEmpty()&&stack1.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        L232 l232 = new L232();
        l232.push(1);

        l232.push(2);
        System.out.println(l232.pop());
        l232.push(3);
        System.out.println(l232.pop());
        l232.push(4);

        System.out.println(l232.pop());
        System.out.println(l232.pop());
    }


}
