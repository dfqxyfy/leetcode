package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2024/11/30 20:22
 *
 * 所有组合数为目标值
 */
public class L39 {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int tempSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,0,0,target);
        return list;

    }
    private void backtrack(int[] candidates,int cur,int count,int target){

        if(count == target){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(cur>=candidates.length){
            return;
        }
        if(count>target){
            return;
        }


        for(int i=cur;i<candidates.length;i++){
            int nextCount = count;
            temp.add(candidates[i]);
            nextCount+=candidates[i];

            backtrack(candidates,i,nextCount,target);

            temp.remove(temp.size()-1);

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5};
        System.out.println(new L39().combinationSum(nums,1));

    }
}
