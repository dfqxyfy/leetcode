package com.ccs.lc;

/**
 * @date 2024/11/16 10:55 PM
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *
 * 不能使用任何内置的库函数，如  sqrt 。
 */
public class L367 {

    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = (start+end+1)/2;
            if(mid * mid == num){
                return true;
            }else{
                if(mid*mid > num){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new L367().isPerfectSquare(17));
    }

}
