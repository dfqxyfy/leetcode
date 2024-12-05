package com.ccs.lc;

/**
 * @date 2024/11/14 5:54 PM
 */
public class L153 {

    public int findMin(int[] nums) throws InterruptedException {

        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int mid = (start+end+1)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }else{
                start = mid;
            }
            System.out.println(start+" - "+end);
            Thread.sleep(1000);
        }
        return nums[start];
    }

    public static void main(String[] args) throws Exception {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
////        nums = new int[]{3,4,5,1,2};
//        int min = new L153().findMin(nums);
//        System.out.println(min);

        int[] nums = {0, 1, 2,4, 5, 6, 7,8,9};
        int val = new L153().findValue(nums,99);
        System.out.println(val);

    }


    public int findValue(int[] nums,int val) throws Exception {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start < end){
            System.out.println(start+" - "+end);
            mid = (start+end+1)/2;
            if(val == nums[mid]){
                return mid;
            }
            if( val < nums[mid]){
                end = mid;
            }
            if( val > nums[mid]){
                start = mid;
            }

            Thread.sleep(1000);
        }
        return -1;

    }

}
