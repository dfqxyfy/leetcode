package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class L47 {

    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return resList;
    }

    private void backtrack(int[] nums){
        if(temp.size()==nums.length){
            resList.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){

            if(i>0&& nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            if(used[i] == false) {
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums);
                temp.removeLast();
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new L47().permuteUnique(nums));
    }
}
