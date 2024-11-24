package com.ccs.lc.binarytree;

/**
 * @date 2024/11/22 11:14 PM
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class L111 {
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null && root.right != null){
            return minDepth(root.right)+1;
        }else if(root.left !=null && root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left !=null && root.right!=null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
        return 0;
    }
}
