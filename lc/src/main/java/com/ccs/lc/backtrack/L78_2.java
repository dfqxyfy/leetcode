package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2024/12/5 10:44
 */
public class L78_2 {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        resList.add(new ArrayList<>());
        return resList;
    }

    public void backtracking(int[] nums,int start){

        if(start>=nums.length){
            return ;
        }
        for(int i=start;i<nums.length;i++) {

            list.add(nums[i]);
            resList.add(new ArrayList<>(list));

            backtracking(nums, i + 1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new L78_2().subsets(nums));
    }
}
