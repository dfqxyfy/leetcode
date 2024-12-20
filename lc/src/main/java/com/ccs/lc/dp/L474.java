package com.ccs.lc.dp;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class L474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        //初始化

        //递推公式

        for(int i=0;i<strs.length;i++){
            int zeroNum = 0;
            int oneNum = 0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '0'){
                    zeroNum++;
                }else if(strs[i].charAt(j)=='1'){
                    oneNum++;
                }
            }

            for(int k=m;k>=0;k--){
                for(int l=n;l>=0;l--){
                    if(k>=zeroNum && l>=oneNum) {
                        dp[k][l] = Math.max(dp[k][l], dp[k - zeroNum][l - oneNum] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
