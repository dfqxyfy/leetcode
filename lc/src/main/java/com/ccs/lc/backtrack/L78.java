package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2024/12/5 10:44
 */
public class L78 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return resList;
    }

    public void backtracking(int[] nums,int start){

        if(start>=nums.length){
            return ;
        }
        for(int i=start;i<nums.length;i++) {

            int[] ints = Arrays.copyOfRange(nums, start, i);
            List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
            resList.add(collect);

            int[] ints2 = Arrays.copyOfRange(nums, i, nums.length);
            List<Integer> collect2 = Arrays.stream(ints2).boxed().collect(Collectors.toList());
            resList.add(collect2);

            backtracking(nums, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new L78().subsets(nums));
    }
}
