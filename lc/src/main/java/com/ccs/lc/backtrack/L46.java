package com.ccs.lc.backtrack;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class L46 {

    private List<List<Integer>> resList = new ArrayList<>();
    private LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums,0,new HashSet<>());

        return resList;

    }

    private void backtrack(int[] nums,int startIndex,Set<Integer> sets){
        if(sets.size()==nums.length){
            resList.add(new ArrayList<>(temp));
            return;
        }

        //Set<Integer> sets = new HashSet<>();
        for(int i=startIndex;i<nums.length;i++){
            if(sets.contains(nums[i])){
                continue;
            }
            sets.add(nums[i]);
            temp.add(nums[i]);

            backtrack(nums,0,sets);

            sets.remove(nums[i]);
            temp.removeLast();

        }
    }

}
