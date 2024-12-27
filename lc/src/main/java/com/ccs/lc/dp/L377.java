package com.ccs.lc.dp;

public class L377 {
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];

        for(int i=0;i<=target;i++){
            if(i%nums[0] == 0){
                dp[0][i] = 1;
            }
        }
        for(int i=0;i<nums.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                if(j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(new L377().combinationSum4(nums,target));;
    }
}
