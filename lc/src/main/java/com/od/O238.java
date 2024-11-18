package com.od;

import java.util.Scanner;

/**
 * @date 2024/10/29 11:15 PM
 *
 * 羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
 *
 * 要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。
 *
 * 只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
 *
 * 备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。
 *
 * 第一行输入为  M N X  分别代表羊的数量，狼的数量，小船的容量。
 *
 * 输出描述
 * 输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数（若无法满足条件则输出 0 ）
 */
public class O238 {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int sheep = scanner.nextInt();
//        int walf = scanner.nextInt();
//        int cap = scanner.nextInt();
//
//        int lsheep = sheep;
//        int lwalf = walf;
//
//        int rsheep = 0;
//        int rwalf = 0;
//
//        while(lsheep>0 || lwalf > 0){
//
//
//        }
//
//    }

    public static int minSteps(int sheep, int wolf, int capacity) {
        if (capacity == 1) {
            return wolf > 0 ? 0 : sheep;
        }

        if (wolf > sheep) {
            return 0;
        }

        int steps = 0;
        int remainingSheep = sheep;
        int remainingWolf = wolf;
        while (remainingSheep > 0 || remainingWolf > 0) {
            if (remainingSheep >= remainingWolf) {
                int toCarry = remainingSheep <= capacity ? remainingSheep : capacity;
                remainingSheep -= toCarry;
            } else {
                int toCarry = remainingWolf <= capacity ? remainingWolf : capacity;
                remainingWolf -= toCarry;
            }

            if (remainingWolf > remainingSheep && remainingSheep > 0) {
                return 0;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sheep = scanner.nextInt();
        int wolf = scanner.nextInt();
        int capacity = scanner.nextInt();

        int steps = minSteps(sheep, wolf, capacity);
        System.out.println(steps);
    }
}
