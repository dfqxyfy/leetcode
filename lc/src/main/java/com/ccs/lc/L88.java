package com.ccs.lc;

/**
 * @date 2024/10/14 1:10 PM
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class L88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n==0){
            return;
        }

        int i=m-1;
        int j=n-1;
        int len = m+n-1;
        while (i>0||j>0){
            if(i==0){
                nums1[len] = nums2[j];
                j--;
            }else if(j==0){
                nums1[len] = nums1[i];
                i--;
            }else if(nums1[i] > nums2[j]){
                nums1[len] = nums1[i];
                i--;
            }else {
                nums1[len] = nums2[j];
                j--;
            }
            len --;
        }
    }


    public static void main(String[] args) {
        int[] nums1 =new int[] {1,2,3,0,0,0};
        int  m = 3;
        int[] nums2 = new int[] {2,5,6};
        int n = 3;
        new L88().merge(nums1,m,nums2,n);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
        nums1 =new int[] {0};
        m = 0;
        nums2 = new int[] {1};
        n = 1;
        new L88().merge(nums1,m,nums2,n);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
    }
}
