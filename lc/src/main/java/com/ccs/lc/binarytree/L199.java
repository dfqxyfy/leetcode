package com.ccs.lc.binarytree;

import com.ccs.MyUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2024/11/22 8:46 PM
 */
public class L199 {
    public List<Integer> rightSideView(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();
        queue.add(root);
        view(queue,resList);
        return resList;
    }

    private void view(Deque<TreeNode> queue,List<Integer> resList){
        if(queue.size() == 0){
            return;
        }
        int size = queue.size();
        TreeNode lastNode = null;
        for(int i=0;i<size;i++){
            lastNode = queue.poll();
            if(lastNode.left!=null) {
                queue.offer(lastNode.left);
            }
            if(lastNode.right!=null){
                queue.offer(lastNode.right);
            }
        }
        resList.add(lastNode.val);
        view(queue,resList);
    }

    public static void main(String[] args) {
        TreeNode init = InitTreeNode.init();
        List<Integer> integers = new L199().rightSideView(init);
        MyUtil.log(integers);
    }
}
