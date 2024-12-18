package com.ccs.lc.dp;

/**
 * 96. 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 */
public class L96 {
    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            int count = 0;
            for(int j=0;j<i;j++){
                count+=dp[j]*dp[i-j-1];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
