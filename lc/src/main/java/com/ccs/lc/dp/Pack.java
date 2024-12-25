package com.ccs.lc.dp;

/**
 * 其实掌握01背包和完全背包
 */
public class Pack {

    public int maxValue(int[] weight,int[] value,int target){
        int[][] dp = new int[weight.length][target+1];

        for(int j=0;j<weight.length;j++){
            dp[j][0] = 0;
        }

        for(int i=1;i<=target;i++){
            dp[0][i] = i/weight[0]*value[0];
        }

        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=target;j++){

                if(weight[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        System.out.println(new Pack().maxValue(weight, value, 5));;

    }
}
