package com.ccs.lc.binarytree;

/**
 * @date 2024/11/25 4:43 PM
 */
public class L1372_2 {


    int maxAns;
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxAns;
    }


    public void dfs(TreeNode o, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);
        if (!dir) {
            if (o.left != null) {
                dfs(o.left, true, len + 1);
            }
            if (o.right != null) {
                dfs(o.right, false, 1);
            }
        } else {
            if (o.right != null) {
                dfs(o.right, false, len + 1);
            }
            if (o.left != null) {
                dfs(o.left, true, 1);
            }
        }
    }



    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1};
        TreeNode root = InitTreeNode.initTreeNode(integers);

        System.out.println(new L1372().longestZigZag(root));
    }

}
