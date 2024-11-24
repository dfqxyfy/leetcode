package com.ccs.lc.binarytree;

/**
 * @date 2024/11/23 5:22 PM
 */
public class L112 {
    boolean exists = false;
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        depthSearch(root,0,targetSum);
        return exists;
    }

    public void depthSearch(TreeNode node,int sumVal ,int target){
        if(exists){
            return;
        }
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(sumVal+node.val == target){
                exists = true;
            }
            return;
        }
        if(node.left != null){
            depthSearch(node.left,sumVal+node.val,target);
        }
        if(node.right!=null){
            depthSearch(node.right,sumVal+node.val,target);
        }
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }
        if(root.left == null && root.right==null && root.val == targetSum){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)|| hasPathSum(root.right,targetSum-root.val);
    }

}
