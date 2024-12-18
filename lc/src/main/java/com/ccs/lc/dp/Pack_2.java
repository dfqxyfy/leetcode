package com.ccs.lc.dp;

public class Pack_2 {


    public int maxValue(int[] weight,int[] value,int target){
        int[] dp = new int[target+1];

        for(int i=1;i<weight.length;i++){
            for(int j=target;j>=1;j--){
                if(weight[i]<=j){
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        System.out.println(new Pack().maxValue(weight, value, 4));;

    }
}
