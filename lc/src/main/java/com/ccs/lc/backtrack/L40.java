package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2024/11/30 20:32
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 */
public class L40 {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,0,0,target);
        return resList;
    }

    public void backtracking(int[] candidates,int cur,int count ,int target){

        if(count == target){
            resList.add(new ArrayList<>(temp));
            return;
        }
        if(count > target){
            return;
        }
        if(cur >= candidates.length){
            return ;
        }

        for(int i=cur;i<candidates.length;i++){
            temp.add(candidates[i]);

            backtracking(candidates,i+1,count+candidates[i],target);
            temp.remove(temp.size()-1);
            while(i+1 < candidates.length && candidates[i+1] == candidates[i]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        nums = new int[]{1,1,2};
        System.out.println(new L40().combinationSum2(nums,3));
    }

}
