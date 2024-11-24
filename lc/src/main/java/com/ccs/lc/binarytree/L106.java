package com.ccs.lc.binarytree;


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * @date 2024/11/24 9:35 AM
 */
public class L106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder.length==0 || postorder.length==0){
            return null;
        }

        Map<Integer,Integer> inordermap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }

        Integer inOrderRootIdx = inordermap.get(postorder[postorder.length - 1]);

        int[] nextInOrderLeft = Arrays.copyOfRange(inorder,0,inOrderRootIdx);
        int[] nextPostOrderLeft = Arrays.copyOfRange(postorder,0,inOrderRootIdx);

        int[] nextInOrderRight = Arrays.copyOfRange(inorder,inOrderRootIdx+1,postorder.length);
        int[] nextPostOrderRight = Arrays.copyOfRange(postorder,inOrderRootIdx,postorder.length-1);

        TreeNode node = new TreeNode(postorder[postorder.length-1]);


        node.left = buildTree(nextInOrderLeft,nextPostOrderLeft );
        node.right = buildTree(nextInOrderRight,nextPostOrderRight);
        return node;
    }


    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        TreeNode treeNode = new L106().buildTree(inorder, postorder);
        System.out.println(treeNode);

    }
}
