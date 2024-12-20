package com.ccs.lc.dp;

/**
 * 难度：中等
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 */
public class L494 {

    int count = 0;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums,0,target);
        return count;
    }

    public void backtracking(int[] nums,int index,int target){
        if(index==nums.length){
            if(sum == target){
                count++;
                return;
            }else{
                return;
            }
        }


        sum+=nums[index];
        backtracking(nums,index+1,target);
        sum-=nums[index];

        sum-=nums[index];
        backtracking(nums,index+1,target);
        sum+=nums[index];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};

        System.out.println(new L494().findTargetSumWays(nums,3));
    }
}
