package com.ccs.lc.dp;

public class BackPack {

    public int maxValue(int[] weight,int[] value,int target){
        int[][] dp = new int[weight.length][target+1];
        for(int i=1;i<=target;i++){
            if(i>=weight[0]) {
                dp[0][i] = Math.max(dp[0][i - 1], value[0] + dp[0][i - weight[0]]);
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=0;i<weight.length;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=target;j++){
                if(j>weight[i]){
                    dp[i][j] =Math.max(dp[i-1][j],value[i]+dp[i-1][j-weight[i]]);
                }else{
                    dp[i][j] =dp[i-1][j];
                }
            }
        }

        return dp[weight.length-1][target];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        System.out.println(new BackPack().maxValue(weight, value, 4));;

    }
}
