package com.ccs.lc.stackandqueue;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 2024/11/22 12:14 AM
 */
public class L347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> allMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            allMap.put(nums[i],allMap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>((a,b)->{
            return b.getValue()-a.getValue();
        });

        allMap.forEach((key,value)->{
            pq.add(new Pair<Integer,Integer>(key,value));
        });

        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i]=pq.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3,3,3};
        int k = 2;
        int[] ints = new L347().topKFrequent(nums, k);
        for(int i=0;i<ints.length;i++) {
            System.out.println(ints[i]);
        }
    }
}
