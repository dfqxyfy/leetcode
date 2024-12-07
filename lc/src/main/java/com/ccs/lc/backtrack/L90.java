package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class L90 {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtracking(nums,0);
        return resList;
    }

    private void backtracking(int[] nums,int start){
        if(start>=nums.length){

            return;
        }

        for(int i=start;i<nums.length;i++){

            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            list.add(nums[i]);
            resList.add(new ArrayList<>(list));
            backtracking(nums,i+1);
            list.remove(list.size()-1);

        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new L90().subsetsWithDup(nums));;

    }
}
