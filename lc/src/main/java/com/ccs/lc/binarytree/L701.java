package com.ccs.lc.binarytree;

/**
 * @date 2024/12/1 11:36
 */
public class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root ==null){
            return new TreeNode(val);
        }

        TreeNode temp = root;
        while(temp != null){
            if(val > temp.val){
                if(temp.right!=null) {
                    temp = temp.right;
                }else{
                    TreeNode node = new TreeNode(val);
                    temp.right = node;
                    break;
                }
            }else{
                if(temp.left!=null){
                    temp = temp.left;
                }else{
                    TreeNode node = new TreeNode(val);
                    temp.left = node;
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        TreeNode treeNode = new L701().insertIntoBST(root, 5);

        System.out.println(treeNode);
    }

}
