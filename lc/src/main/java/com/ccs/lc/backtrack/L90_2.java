package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L90_2 {

    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> list = new LinkedList<>();

    boolean[] used ;
    public List<List<Integer>> subsets(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,0);
        return resList;
    }

    public void backtracking(int[] nums,int startIndex){
        resList.add(new ArrayList<>(list));

        for(int i=startIndex;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){}
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums,i+1);
            list.remove(list.size()-1);
            used[i] = false;
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new L90_2().subsets(nums));
    }

}
