package com.ccs.lc.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class L62 {

    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        nums[0][0] = 0;
        for(int i=1;i<m;i++){
            nums[i][0] = 1;
        }
        for(int j=1;j<n;j++){
            nums[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                nums[i][j] = nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[m-1][n-1];
    }


}
