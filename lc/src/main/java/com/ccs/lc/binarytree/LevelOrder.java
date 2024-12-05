package com.ccs.lc.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2024/11/22 2:45 PM
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        List<List<Integer>> resList = new ArrayList<>();
        level(queue,resList);


        return resList;
    }

    private void level(Deque<TreeNode> queue,List<List<Integer>> resList){
        if(queue.size()==0){
            return;
        }
        List<Integer> levelList = new ArrayList<>();

        Deque<TreeNode> queueNext = new LinkedList<>();

        while(queue.size()>0){
            TreeNode pop = queue.pop();
            levelList.add(pop.val);
            if(pop.left!=null) {
                queueNext.add(pop.left);
            }
            if(pop.right!=null) {
                queueNext.add(pop.right);
            }
        }
        resList.add(levelList);
        level(queueNext,resList);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)), new TreeNode(5));
        List<List<Integer>> resList = new LevelOrder().levelOrder(treeNode);

        for(int i=0;i< resList.size();i++){
            for(int j=0;j<resList.get(i).size();j++){
                System.out.print(resList.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }


}


