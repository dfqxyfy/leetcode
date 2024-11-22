package com.ccs.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2024/11/22 12:00 PM
 */
public class MySort {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,2,1,4};
        Arrays.sort(nums, (a,b)->{
            return a-b;
        });

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
