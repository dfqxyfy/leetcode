package com.ccs.lc;

import com.ccs.MyUtil;

/**
 * @date 2024/11/18 10:35 AM
 */
public class L283 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(fast<nums.length){
            if(nums[fast] !=0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for(int i=slow;i<nums.length;i++){
            nums[i] = 0;
        }
        MyUtil.info(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        nums = new int[]{0,1};
        new L283().moveZeroes(nums);
    }
}
