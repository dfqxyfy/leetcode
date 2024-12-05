package com.ccs.lc.binarytree;

/**
 * @date 2024/12/1 22:24
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class L450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key == root.val) {
            if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else if (root.right == null && root.left == null) {
                return null;
            } else if (root.right != null && root.left != null) {
                TreeNode lastRight = root.right;
                while (lastRight.left != null) {
                    lastRight = lastRight.left;
                }
                //删除节点
                root.right = deleteNode(root.right, lastRight.val);
                lastRight.right = root.right;
                lastRight.left = root.left;
                return lastRight;
            }

        }
        return root;
    }
}
