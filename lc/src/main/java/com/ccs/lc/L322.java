package com.ccs.lc;

/**
 * @date 2024/11/14 10:06 PM
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class L322 {

    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

        for(int i=0;i<coins.length;i++){
            if(amount == coins[i]){
                return 1 ;
            }
            if(amount-coins[i] < 0){
                return -1;
            }
            coinChange(coins,amount-coins[i]);
        }
        return 0;

    }

    public int coinChange(int[] coins, int count, int amount) {
        int min = 0;
        for(int i=0;i<coins.length;i++){
            if(amount == coins[i]){
                return 1 ;
            }
            if(amount-coins[i] < 0){
                return -1;
            }
            int cout = coinChange(coins,amount-coins[i])+1;
        }
        return 1;
    }

}
