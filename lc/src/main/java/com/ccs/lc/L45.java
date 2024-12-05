package com.ccs.lc;

/**
 * @date 2024/10/14 11:38 PM
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class L45 {
    public int jump(int[] nums) {
        int start = 0;
        int end = nums[0]-1;
        int jumpCount = 0;
        while(start < end ){
            for(int i=start;i<end;i++){

            }
        }
        return 1;
    }
}
