package com.ccs.lc.binarytree;

/**
 * @date 2024/11/24 1:08 PM
 */
public class L617 {

    public TreeNode mergeTreeNode(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val = t1.val+t2.val;
        t1.left = mergeTreeNode(t1.left,t2.left);
        t1.right = mergeTreeNode(t1.right,t2.right);
        return t1;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val = root1.val+root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }


}
