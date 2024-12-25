package com.ccs.lc.dp;

import java.util.Arrays;

public class L518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }


    public int change2(int amount, int[] coins){
        int dp[][] = new int[coins.length][amount+1];

        dp[0][0] = 0;
        Arrays.sort(coins);

        for(int i=1;i<=amount;i++){
            if(i>=coins[0]) {
                dp[0][i] = 1;
            }
        }
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //System.out.println(dp[coins.length-1][amount]);

        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1,2,5};
        System.out.println(new L518().change2(amount,coins));;
    }
}
