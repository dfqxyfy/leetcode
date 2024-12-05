package com.ccs.lc.binarytree;

/**
 * @date 2024/12/1 11:36
 */
public class L701_2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }

        if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        TreeNode treeNode = new L701_2().insertIntoBST(root, 5);

        System.out.println(treeNode);
    }

}
