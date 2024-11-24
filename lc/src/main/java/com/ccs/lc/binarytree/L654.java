package com.ccs.lc.binarytree;

/**
 * @date 2024/11/24 12:31 PM
 */
public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = constructMaximumBinaryTree(nums,0,nums.length-1);
        return treeNode;
    }

    TreeNode constructMaximumBinaryTree(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for(int i=start;i<=end;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(nums,start,maxIdx-1);
        node.right = constructMaximumBinaryTree(nums,maxIdx+1,end);
        return node;
    }

}
