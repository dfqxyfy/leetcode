package com.ccs.lc.dp;

/**
 * 难度：中等
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 */
public class L494_2 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int xTarget = (sum+target)/2;

        int[] dp = new int[xTarget+1];
        for(int i=0;i<nums.length;i++){
            for(int j=xTarget;j>=0;j--){
                if(j>=nums[i]){
                    dp[j] = dp[j]+dp[j-nums[j]];
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};

        System.out.println(new L494_2().findTargetSumWays(nums,3));
    }
}
