package com.ccs.lc.binarytree;

/**
 * @date 2024/11/22 10:01 PM
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class L104 {

    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxDepth(root,1);
        return max;
    }
    public void maxDepth(TreeNode root,int depth){
        max = Math.max(max,depth);
        if(root == null){
            return;
        }else{
            if(root.left!=null){
                maxDepth(root.left,depth+1);
            }
            if(root.right!=null){
                maxDepth(root.right,depth+1);
            }
        }
    }

    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftHight = maxDepth2(root.left);
            int rightHight = maxDepth2(root.right);
            return Math.max(leftHight,rightHight)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode init = InitTreeNode.init();
        System.out.println(new L104().maxDepth(init));;
    }
}
