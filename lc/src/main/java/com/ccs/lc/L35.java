package com.ccs.lc;

import com.ccs.MyUtil;

/**
 * @date 2024/11/16 3:57 PM
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 */
public class L35 {
    public int searchInsert(int nums[],int target){
        int start = 0;
        int end = nums.length-1;

        if(target < nums[0]){
            return 0;
        }
        if(target > nums[nums.length-1]){
            return nums.length;
        }

        int mid = 0;
        while(start <= end){

            //MyUtil.sleep();
            mid = (start + end + 1)/2;
            MyUtil.log(start,mid,end);
            if(nums[mid] == target || (nums[mid] > target && nums[mid-1] < target)){
                return mid;
            }else if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target){
                end = mid-1;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println( new L35().searchInsert(nums, 0));;
        System.out.println( new L35().searchInsert(nums, 5));;
        System.out.println( new L35().searchInsert(nums, 2));;
        System.out.println( new L35().searchInsert(nums, 7));;

        nums = new int[]{1,3};
        System.out.println( new L35().searchInsert(nums, 1));;
    }
}
