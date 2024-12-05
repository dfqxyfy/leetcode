package com.od;

import java.util.Scanner;

/**
 * @date 2024/10/24 1:46 PM
 *
 * 一天一只顽猴想要从山脚爬到山顶，
 * 途中经过一个有n个台阶的阶梯，
 * 但是这个猴子有个习惯，每一次只跳1步或3步
 * 试问？猴子通过这个阶梯有多少种不同的跳跃方式
 * 50
 * 122106097
 */
public class O4 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();

        walk(step);
        System.out.println(count);
    }


    private static void walk(int step){
        if(step==0){
            count++;
            return;
        }
        if(step < 0){
            return;
        }
        if(step > 0){
            walk(step - 1);
            walk(step - 3);
        }

    }
}
