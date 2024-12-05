package com.ccs.lc;

import com.ccs.MyUtil;

/**
 * @date 2024/11/18 4:17 PM
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 */
public class L59 {

    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] nums = new int[n][n];
        int startx = 0;
        int endx = n-1;
        int starty=0;
        int endy = n-1;
        while(startx<=endx && starty<=endy){
            for(int i=starty;i<endy;i++){
                nums[startx][i] = num;
                num++;
            }
            for(int i=startx;i<endx;i++){
                nums[i][endy] = num;
                num++;
            }
            for(int i=endy;i>starty;i--){
                nums[endx][i] = num;
                num++;
            }
            for(int i=endx;i>startx;i--){
                nums[i][starty] = num;
                num++;
            }
            if(startx == endx && starty == endy){
                nums[startx][endy] = num;
            }
            startx++;
            endx--;
            starty++;
            endy--;
        }
        return nums;

    }

    public static void main(String[] args) {
        int[][] ints = new L59().generateMatrix(5);
        MyUtil.info(ints);
    }
}
