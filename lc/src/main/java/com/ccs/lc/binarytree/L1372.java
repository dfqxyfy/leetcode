package com.ccs.lc.binarytree;

/**
 * @date 2024/11/25 3:28 PM
 *
 * 二叉树中的最长交错路径
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 *
 */
public class L1372 {

    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,true,0);
        dfs(root,false,0);
        return max;
    }

    public void dfs(TreeNode node, boolean isLeft, int depth) {
        max = Math.max(max, depth);
        if (isLeft) {
            if (node.left != null) {
                dfs(node.left, true, 1);
            }
            if (node.right != null) {
                dfs(node.right, false, depth + 1);
            }
        } else if (!isLeft) {
            if (node.left != null) {
                dfs(node.left, true, depth + 1);
            }
            if (node.right != null) {
                dfs(node.right, false, 1);
            }
        }
    }






    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1};
        TreeNode root = InitTreeNode.lcInit(nums);

        System.out.println(new L1372().longestZigZag(root));
    }
}
