package com.ccs.lc;

/**
 * @date 2024/11/17 12:35 AM
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 */
public class L26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow +=1;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2};
        System.out.println(new L26().removeDuplicates(nums));;
        nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new L26().removeDuplicates(nums));;

    }
}
