package com.ccs.lc;

/**
 * @date 2024/11/16 10:41 PM
 */
public class L69 {

    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int res = -1;
        while(start<=end){
            int mid = (start+end+1)/2;

            if((long)mid*mid <= x){
                res = mid;
                start = mid + 1;
            }else if((long)mid*mid > x){
                end = mid - 1;
            }
        }
        return res;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new L69().mySqrt(x));
        System.out.println(new L69().mySqrt2(x));
    }
}
