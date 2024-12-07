package com.ccs.lc.backtrack;

import java.util.*;

public class L491 {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0);
        return resList;
    }

    public void backtrack(int[] nums,int startIndex){
        Set<Integer> sets = new HashSet<>();
        for(int i=startIndex;i<nums.length;i++){
            if(temp.size()>0 && temp.getLast() > nums[i] || sets.contains(nums[i])){
                continue;
            }
            sets.add(nums[i]);
            temp.add(nums[i]);
            if(temp.size()>1){
                resList.add(new ArrayList<>(temp));
            }

            backtrack(nums,i+1);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,};
        System.out.println(new L491().findSubsequences(nums));;
    }
}
