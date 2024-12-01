package com.ccs.lc.binarytree;

/**
 * @date 2024/11/24 2:17 PM
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 *
 */
public class L98 {
    public boolean isValidBST(TreeNode root) {

        return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode node,long lower,long upper){
        if(node == null){
            return true;
        }
        if(node.val <= lower || node.val >= upper){
            return false;
        }
        return validBST(node.left,lower,node.val)&&validBST(node.right,node.val,upper);
    }


    public static void main(String[] args) {
        TreeNode treeNode = InitTreeNode.initTreeNode(new Integer[]{2, 1, 3});
        //treeNode = InitTreeNode.initTreeNode(new Integer[]{5,4,6,null,null,3,7});
        boolean b = new L98().isValidBST(treeNode);
        System.out.println(b);
    }
}
