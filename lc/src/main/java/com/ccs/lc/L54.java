package com.ccs.lc;

import com.ccs.MyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/11/18 6:40 PM
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class L54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int startx = 0;
        int endx = matrix.length-1;
        int starty = 0;
        int endy = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(startx<=endx && starty<=endy) {
            MyUtil.log(startx,starty,endx,endy);
            for (int i = starty; i <= endy; i++) {
                MyUtil.log(startx,i);
                list.add(matrix[startx][i]);
            }
            for (int i = startx + 1; i <= endx; i++) {
                MyUtil.log(i,endy);
                list.add(matrix[i][endy]);
            }
            for (int i = endy - 1; i > starty; i--) {
                MyUtil.log(endx,i);
                list.add(matrix[endx][i]);
            }
            for (int i = endx - 1; i > startx; i--) {
                MyUtil.log(i,startx);
                list.add(matrix[i][startx]);
            }
            startx++;
            starty++;
            endx--;
            endy--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        res = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> x = new L54().spiralOrder(res);
        System.out.println(x);
        //1,2,3,4,8,12,11,10,9,5,6,7,6
        //1,2,3,4,8,12,11,10,9,5,6,7

    }
}
