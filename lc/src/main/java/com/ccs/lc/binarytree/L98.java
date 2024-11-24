package com.ccs.lc.binarytree;

/**
 * @date 2024/11/24 2:17 PM
 */
public class L98 {
    public boolean isValidBST(TreeNode root) {

        return validBST(root,null);
    }

    public boolean validBST(TreeNode node, Integer parentValue){
        if(node == null){
            return true;
        }
        if(node.left!=null && (node.left.val >= node.val || (parentValue!=null && node.left.val >=parentValue))){
            return false;
        }
        if(node.right!=null && (node.right.val <= node.val || (parentValue!=null && node.right.val <=parentValue))){
            return false;
        }
        return validBST(node.left,node.val)&&validBST(node.right,node.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = InitTreeNode.initTreeNode(new Integer[]{2, 1, 3});
        treeNode = InitTreeNode.initTreeNode(new Integer[]{5,4,6,null,null,3,7});
        boolean b = new L98().validBST(treeNode, null);
        System.out.println(b);
    }
}
