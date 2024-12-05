package com.ccs.lc.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/21 5:29 PM
 */
public class L255 {

    Deque<Integer> queue1 = new LinkedList<>();
    Deque<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while(queue1.size()>1){
            Integer poll = queue1.poll();
            queue2.push(poll);
        }
        Integer poll = queue1.poll();

        while(!queue2.isEmpty()){
            queue1.push(queue2.pop());
        }
        return poll;
    }

    public int top() {
        Integer poll = 0;
        while(queue1.size()>=1){
            poll = queue1.poll();
            queue2.push(poll);
        }

        while(!queue2.isEmpty()){
            queue1.push(queue2.pop());
        }
        return poll;
    }

    public boolean empty() {
        return queue1.isEmpty();

    }

    public static void main(String[] args) {
        L255 l255 = new L255();
        l255.push(1);
        l255.push(2);
        System.out.println(l255.pop());
        l255.push(3);

        System.out.println(l255.pop());
        System.out.println(l255.pop());
    }

}
