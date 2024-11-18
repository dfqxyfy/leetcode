package com.ccs.lc;

/**
 * @date 2024/11/16 2:03 PM
 */
public class L34 {

    public int[] searchRange(int[] nums, int target) {

        int left = minLeftVal(nums,target);
        int right = minRightVal(nums,target);

        return new int[]{left,right};
    }

    private int minLeftVal(int[] nums,int target){
        int mid = 0;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[start]>target || nums[end]<target){
                return -1;
            }
            mid = (start+end)/2;
            if(nums[mid] == target && ((mid-1>=0) && nums[mid-1]<target|| mid-1==0) ){
                return mid;
            }else if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] >= target){
                end = mid;
            }else{
                return -1;
            }

        }
        return -1;
    }


    private int minRightVal(int[] nums,int target){
        int mid = 0;
        int start = 0;
        int end = nums.length-1;
        while(start<end){

            mid = (start+end)/2;
//            System.out.println(start+" "+mid+" " + end);
            if(nums[start]>target || nums[end]<target){
                return -1;
            }
            if(nums[mid] == target && ((mid+1<nums.length) && nums[mid+1]>target || mid+1 == nums.length)){
                return mid;
            }else if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] <= target){
                start = mid+1;
            }else{
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new L34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(ints[0] + " " + ints[1]);
    }

}
