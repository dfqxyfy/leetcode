package com.ccs.lc.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2024/11/22 5:13 PM
 */
public class InitTreeNode {

    public static TreeNode initTreeNode(Integer[] nums){
        TreeNode treeNode = new TreeNode(nums[0]);
        init(treeNode,nums,0);
        return treeNode;
    }
    private static void init(TreeNode parent,Integer[] nums,int idx){
        if( parent == null){
            return;
        }
        //parent.val = nums[idx];

        int leftIdx = idx*2+1;
        int rightIdx = idx*2+2;
        if(rightIdx>=nums.length){
            return;
        }
        TreeNode left = null;
        TreeNode right = null;
        if(leftIdx < nums.length ){
            //System.out.println(leftIdx);
            if(nums[leftIdx] != null){
                left = new TreeNode(nums[leftIdx]);
                init(left,nums,leftIdx);
            }
        }
        if(rightIdx<nums.length){
            if(nums[rightIdx]!=null) {
                right = new TreeNode(nums[rightIdx]);
                init(right, nums, rightIdx);
            }
        }

        parent.left = left;
        parent.right =right;

    }

    public static TreeNode init(){
        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = initTreeNode(nums);
        return treeNode;
    }


    public static TreeNode lcInit(Integer[] nums){
        if(nums == null || nums.length == 0 ){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode treeNode = new TreeNode(nums[index++]);
        queue.add(treeNode);

        while(queue.size()>0){
            int count = queue.size();
            for(int i=0;i<count;i++){
                TreeNode poll = queue.poll();
                if(2*i+index >= nums.length){
                    return treeNode;
                }
                if(nums[2*i+index] == null){
                    poll.left = null;
                }else{
                    TreeNode temp = new TreeNode(nums[2*i+index]);
                    poll.left = temp;
                    queue.offer(temp);
                }

                if(nums[2*i+index+1] == null){
                    poll.right = null;
                }else{
                    TreeNode temp = new TreeNode(nums[2*i+index+1]);
                    poll.right = temp;
                    queue.offer(temp);
                }
            }
            index += 2*count;
        }

        return treeNode;

    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = new InitTreeNode().initTreeNode(nums);
        System.out.println(treeNode);
    }
}
