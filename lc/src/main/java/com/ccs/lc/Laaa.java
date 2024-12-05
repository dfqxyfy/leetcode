package com.ccs.lc;

/**
 * @date 2024/10/15 5:00 PM
 */
public class Laaa {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,3};
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = res^nums[i];
        }
        System.out.println(res);

        System.out.println(5^5);


    }
}
