package com.ccs.lc.binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/11/23 3:47 PM
 */
public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        build(root,new StringBuilder(""),list);
        return list;
    }

    public void build(TreeNode root,StringBuilder strb,List<String> resList){
        if(root == null){
            return ;
        }
        if(strb.length()>0){
            strb.append("->");
        }
        strb.append(root.val);

        if(root.left == null && root.right == null){
            resList.add(strb.toString());
            return;
        }
        if(root.left!=null){
            build(root.left,new StringBuilder(strb),resList);
        }
        if(root.right!=null){
            build(root.right,new StringBuilder(strb),resList);
        }
    }

}
