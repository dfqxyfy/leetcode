package com.ccs.lc.dp;


/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class L416_2 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        int count = sum/2;

        if(count * 2 != sum){
            return false;
        }

        int[] dp = new int[sum/2+1];

        for(int i=0;i<nums.length;i++){
            for(int j=count;j>=0;j--){
                if(j>nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[dp.length-1]== count;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        //nums = new int[]{1,1};

        System.out.println(new L416_2().canPartition(nums));;
    }
}
