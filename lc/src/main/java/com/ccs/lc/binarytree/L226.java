package com.ccs.lc.binarytree;

/**
 * @date 2024/11/23 12:09 AM
 *
 *  翻转二叉树
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode head = root;
        invert(root);
        return head;
    }

    private void invert(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
