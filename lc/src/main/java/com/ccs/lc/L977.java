package com.ccs.lc;

import com.ccs.MyUtil;

/**
 * @date 2024/11/18 3:54 PM
 */
public class L977 {

    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        int[] res = new int[nums.length];
        int idx = nums.length-1;
        while(end >= start){
            int st2 = nums[start]*nums[start];
            int en2 =  nums[end]*nums[end];
            if(st2>en2){
                res[idx] = st2;
                start++;
            }else{
                res[idx] = en2;
                end--;
            }
            idx--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-4,-1,0,3,10};
        int[] ints = new L977().sortedSquares(nums);
        MyUtil.info(ints);
    }

}
