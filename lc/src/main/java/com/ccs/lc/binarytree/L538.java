package com.ccs.lc.binarytree;/**
 *@date 2024/12/2 10:36
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class L538 {

    public TreeNode convertBST(TreeNode root) {
        val(root);
        return root;
    }

    private int pre = 0;
    private void val(TreeNode node){

        if(node == null){
            return;
        }
        val(node.right);
        node.val += pre;
        pre = node.val;

        val(node.left);
    }

}
