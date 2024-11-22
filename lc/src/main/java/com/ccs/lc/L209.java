package com.ccs.lc;

/**
 * @date 2024/11/18 11:03 PM
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int fast = 0;
        int slow = 0;
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        while(fast<nums.length&&slow<=fast){

            if(sum<target){
                sum+=nums[fast];
                fast++;
            }

            while(sum>=target){
                minVal = Math.min(minVal,fast-slow);
                sum-=nums[slow];
                slow++;
            }

        }
        if(minVal== Integer.MAX_VALUE){
            return 0;
        }
        return minVal;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(new L209().minSubArrayLen(target,nums));;
    }
}
