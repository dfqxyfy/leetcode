package com.od;

import java.util.Scanner;

/**
 * @date 2024/10/24 1:35 PM
 * 为了充分发挥GPU算力，
 * 需要尽可能多的将任务交给GPU执行，
 * 现在有一个任务数组，
 * 数组元素表示在这1s内新增的任务个数，
 * 且每秒都有新增任务，
 * 假设GPU最多一次执行n个任务，
 * 一次执行耗时1s，
 * 在保证GPU不空闲的情况下，最少需要多长时间执行完成。
 *
 *
 * 第一个参数为GPU最多执行的任务个数，取值范围1 ~ 10000
 * 第二个参数为任务数组的长度，取值范围1 ~ 10000
 * 第三个参数为任务数组，数字范围1 ~ 10000
 *
 * 3
 * 5
 * 1 2 3 4 5
 *
 * 6
 */
public class O5 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int gpuNum = scanner.nextInt();
        int arrLen = scanner.nextInt();
        int[] tasks = new int[arrLen];
        for(int i=0;i<arrLen;i++){
            tasks[i] = scanner.nextInt();
        }

        int remain = 0;
        for(int i=0;i<tasks.length;i++){
            if(remain+tasks[i] > gpuNum){
                remain = remain+tasks[i] - gpuNum;
            }else{
                remain = 0;
            }
        }
        if(remain ==0){
            System.out.println(arrLen);
        }else{
            int add = 0;
            if(remain%arrLen > 0){
                add = 1;
            }
            int res = remain/arrLen+ add + arrLen;
            System.out.println(res);
        }
    }
}
