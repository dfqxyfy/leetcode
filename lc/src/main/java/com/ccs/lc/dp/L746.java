package com.ccs.lc.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class L746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] nums = new int[cost.length+1];

        if(cost.length==0){
            return 0;
        }
        if(cost.length==1){
            return 0;
        }

        for(int i=2;i<=cost.length;i++){
            nums[i] = Math.min(cost[i-1]+nums[i-1],cost[i-2]+nums[i-2]);
        }
        return nums[cost.length];
    }

}
