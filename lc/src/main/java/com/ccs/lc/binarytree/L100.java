package com.ccs.lc.binarytree;

/**
 * @date 2024/11/23 3:05 PM
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 *
 */
public class L100 {
    boolean banlanced = true;
    public boolean isBalanced(TreeNode root) {
        int depth = depth(root);
        return banlanced;
    }

    public int depth(TreeNode root){
        if(!banlanced){
            return 0;
        }
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left-right) > 1){
            banlanced = false;
            return 0;
        }
        return Math.max(left,right)+1;

    }
}
