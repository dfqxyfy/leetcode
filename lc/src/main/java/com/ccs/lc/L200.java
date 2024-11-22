package com.ccs.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2024/11/20 12:10 PM
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class L200 {

    Set<Integer> sets = new HashSet<>();

    public boolean isHappy(int n) {
        if(sets.contains(n)){
            return false;
        }else{
            sets.add(n);
        }
        int count =0;
        while(n>0){
            int c = n%10;
            count += c*c;
            n=n/10;
        }
        if(count == 1){
            return true;
        }
        return isHappy(count);
    }

    public static void main(String[] args) {
        System.out.println(new L200().isHappy(19));;
        System.out.println(new L200().isHappy(2));;
    }
}
