package com.temp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date 2024/11/11 12:38 PM
 */
public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        heap.add(3);
        heap.add(2);
        heap.add(3);
        heap.add(3);
        heap.add(1);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
