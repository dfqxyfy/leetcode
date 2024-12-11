package com.ccs.lc.dp;

/**
 *
 * 63. 不同路径 II
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 * 返回机器人能够到达右下角的不同路径数量。
 * 测试用例保证答案小于等于 2 * 109。
 */
public class L63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] nums = new int[obstacleGrid.length][obstacleGrid[0].length];

        boolean hasOne = false;
        for(int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0] == 1){
                hasOne = true;
            }
            if(hasOne){
                nums[i][0] = 0;
            }else{
                nums[i][0] = 1;
            }
        }

        hasOne = false;
        for(int i=0;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i] == 1){
                hasOne = true;
            }
            if(hasOne){
                nums[0][i] = 0;
            }else{
                nums[0][i] = 1;
            }
        }

        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j] == 1){
                    nums[i][j] = 0;
                }else{
                    nums[i][j] = nums[i-1][j]+nums[i][j-1];
                }
            }
        }
        return nums[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        new L63().uniquePathsWithObstacles(obstacleGrid);
    }
}
