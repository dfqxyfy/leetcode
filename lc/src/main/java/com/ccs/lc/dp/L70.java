package com.ccs.lc.dp;

/**
 * 70. 爬楼梯
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class L70 {

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;

        for(int i=2;i<n;i++){
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }
}
