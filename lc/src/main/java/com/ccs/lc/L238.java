package com.ccs.lc;

/**
 * @date 2024/10/21 9:10 PM
 */
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[nums.length-1]=1;
        for(int j=nums.length-2;j>=0;j--){
            right[j] = right[j+1] * nums[j+1];
        }

        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        nums = new int[]{-1,1,0,-3,3};
        int[] ints = new L238().productExceptSelf(nums);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+"\t");
        }
    }
}
