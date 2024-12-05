package com.ccs.daima;

/**
 * @date 2024/11/18 10:10 PM
 */
public class C44 {
    public int minArea(int[][] nums){

        int minVal = 0;

        int[] rowval=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                rowval[i]+=nums[i][j];
            }
            if(i>0){
                rowval[i]+=rowval[i-1];
            }
        }
        for(int i=0;i<rowval.length;i++){
            minVal = Math.min(Math.abs(rowval[rowval.length-1] - rowval[i]-rowval[i]) ,minVal);
        }


        int[] colval=new int[nums[0].length];
        for(int i=0;i<nums[0].length;i++){
            for(int j=0;j<nums.length;j++){
                colval[i]+=nums[j][i];
            }
            if(i>0){
                colval[i]+=colval[i-1];
            }
        }
        for(int i=0;i<colval.length;i++){
            minVal = Math.min(Math.abs(colval[colval.length-1] - colval[i]-colval[i]) ,minVal);
        }
        return minVal;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{2,1,3},{1,2,3}};

        System.out.println(new C44().minArea(nums));;
    }
}
