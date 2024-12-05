package com.ccs.lc.binarytree;

/**
 * @date 2024/11/23 12:46 AM
 */
public class L101 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode p,TreeNode q){
        if(p==null && q == null){
            return true;
        }
        if(p==null || q== null){
            return false;
        }
        return p.val==q.val && compare(p.left,q.right) && compare(p.right,q.left);
    }
}
