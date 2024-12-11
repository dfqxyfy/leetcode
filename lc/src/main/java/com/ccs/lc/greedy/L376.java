package com.ccs.lc.greedy;

public class L376 {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int count = 1;

        int index = 0;
        while(index<nums.length){
            if(index==0){
                index++;
                continue;
            }
            if(nums[index]>=nums[index-1]){
                index++;
            }
        }
        return 0;
    }
}
