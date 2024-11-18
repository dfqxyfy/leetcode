package com.ccs.lc;

/**
 * @date 2024/11/5 11:42 PM
 */
public class L42 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for(int i=0;i<height.length-1;i++){
            left[i+1] = Math.max(height[i],left[i]);
        }


        for(int i=height.length-1;i>0;i--){
            right[i-1] = Math.max(height[i],right[i]);
        }
        int sum = 0;
        for(int i=0;i<height.length;i++){
            int min = Math.min(left[i], right[i]);
            if(height[i] < min){
                sum+= min-height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        height = new int[] {4,2,0,3,2,5};
        System.out.println(new L42().trap(height));
    }
}
