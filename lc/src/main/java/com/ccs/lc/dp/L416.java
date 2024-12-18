package com.ccs.lc.dp;


/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class L416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int c = sum/2;

        int[] dp = new int[c+1];


        for(int i=1;i<nums.length;i++){
            for(int j=c;j>=1;j--){
                if(j>=nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
                //else{
                //    dp[i][j] = dp[i - 1][j];
                //}
            }
        }
        if(dp[dp.length-1] == c){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,13,5};
        nums = new int[]{1,1};

        System.out.println(new L416().canPartition(nums));;
    }
}
