package com.ccs.lc.binarytree;

/**
 * @date 2024/12/2 10:12
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return genNode(nums,0,nums.length-1);
    }

    public TreeNode genNode(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = genNode(nums,start,mid-1);
        node.right= genNode(nums,mid+1,end);
        return node;
    }

}
