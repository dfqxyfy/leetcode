package com.ccs.lc.dp;

/**
 *
 */
public class L518_2 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int j=1;j<=amount;j++){
            if(j%coins[0] == 0) {
                dp[0][j] = 1;
            }
        }
        dp[0][0] = 1;

        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length-1][amount];
    }

        public int change2(int amount, int[] coins) {

            int n = coins.length;
            // dp[i][j] 表示使用前i个硬币，凑出零钱j的硬币组合数
            // 换句话说就是使用前i个物品，装满容量为j的背包的组合数
            int[][] dp = new int[n+1][amount+1];
            // base case dp[0][j] = 0; dp[i][0] = 1;
            for(int i = 0; i <= n; i++){
                dp[i][0] = 1; // amount为0时，哪个硬币都不用也是一种方式
            }

            for(int i =1; i <= n; i++){
                for(int j = 1; j <= amount; j++){
                    // dp[i-1][j-coins[i-1]]将当前硬币装入背包, dp[i-1][j]代表不装入
                    // 由于是求总的组合数，因此装与不装，只要满足凑出amount都是一种方式，因此需要相加
                    if(j - coins[i-1] >= 0){ // 防止下标越界
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                    }else dp[i][j] = dp[i-1][j];
                }
            }
            return dp[n][amount];
        }

    public int change3(int amount, int[] coins) {
        int len=coins.length;
        int[][]dp=new int[len+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=len;i++){
            int coin=coins[i-1];
            for(int j=0;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                if(j-coin>=0)dp[i][j]+=dp[i][j-coin];
            }
        }
        return dp[len][amount];
    }

    public static void main(String[] args) {
        int amount = 5;

        int[] coins = new int[]{1,2,5};
        System.out.println(new L518_2().change(amount,coins));;
        System.out.println(new L518_2().change2(amount,coins));;
        System.out.println(new L518_2().change3(amount,coins));;
    }
}