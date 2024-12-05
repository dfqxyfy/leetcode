package com.ccs.lc;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

/**
 * @date 2024/10/14 10:52 PM
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class L55 {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(maxIndex < i){
                return false;
            }
            maxIndex = Math.max(nums[i]+i,maxIndex);
            if(maxIndex>nums.length-1){
                maxIndex=nums.length-1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new L55().canJump(nums));;

        nums = new int[]{3,2,1,0,4};
        System.out.println(new L55().canJump(nums));;
    }
}
