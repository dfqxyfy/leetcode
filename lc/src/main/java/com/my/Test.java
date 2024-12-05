package com.my;

import java.util.Random;

/**
 * @date 2024/11/1 3:18 PM
 */
public class Test {


    private int total =0;

    private int[][] arrs;

    int[] pers = genPer(arrs);

    public void draw(int[][] arrs){

        boolean over = true;
        for(int i=0;i<pers.length;i++){
            if(pers[i]>0){
                over = false;
                break;
            }
        }
        if(over){
            return;
        }
        int num = new Random().nextInt(total)+1;

        int drawLevel = -1;

        for(int i=0;i<pers.length;i++){
            if(num >=pers[i]){
                drawLevel = i;
                arrs[i][0] = arrs[i][0]-1;

                if(arrs[i][0] == 0){
                    pers = genPer(arrs);
                }
            }
        }

    }


    public synchronized int[] genPer(int[][] arrs){
        total = 0;
        int[] pers = new int[arrs.length];
        int preNotNull =0;
        for(int i=0;i<arrs.length;i++){
            if(arrs[i][0]!=0){
                pers[i] = arrs[i][1]*1000+preNotNull;
                preNotNull = pers[i];
                total += arrs[i][0];
            }
        }
        return pers;
    }

    public static void main(String[] args) {
        double[][] arrs= new double[][]{{5,0.1d},{}};


    }


}
