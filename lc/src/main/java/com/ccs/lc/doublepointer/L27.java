package com.ccs.lc.doublepointer;

/**
 * @date 2024/11/17 12:26 AM
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 */
public class L27 {

    public int removeEle(int[] nums,int target){
        int fast = 0;
        int slow = 0;

        while(fast < nums.length){
            if(nums[fast] == target){
                fast++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new L27().removeEle(nums, 3));;
        System.out.println("over");

        nums= new int[]{0,1,2,2,3,0,4,2};
        System.out.println(new L27().removeEle(nums, 2));;
    }
}
