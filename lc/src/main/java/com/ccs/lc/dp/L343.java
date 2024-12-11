package com.ccs.lc.dp;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 */
public class L343 {

    public int integerBreak(int n) {

        int[] dp = new int[n+1];

        int max = 0;
        for(int i=2;i<=n;i++) {
            for(int j=1;j<i;j++){
                max = Math.max(max,Math.max(dp[i-j]*j,(i-j)*j));
            }
            dp[i] = max;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new L343().integerBreak(2));
        System.out.println(new L343().integerBreak(3));
        System.out.println(new L343().integerBreak(10));
        System.out.println(new L343().integerBreak(31));
    }

}
