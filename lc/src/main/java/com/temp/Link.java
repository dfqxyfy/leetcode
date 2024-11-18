package com.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/10/22 4:15 PM
 */
public class Link {

    public Node initLink(){
        int[] nums = new int[]{1,2,3,4,5};
        Node head = new Node(0);
        Node tail = null;
        Node temp = head;
        for(int i=0;i<nums.length;i++){
            Node node = new Node(nums[i]);
            tail = node;
            temp.next = node;
            node.pre = temp;
            temp = temp.next;
        }
        return head.next;
    }


    public Tree binaryTree(){
        Node node = initLink();
        Tree tree = new Tree(node.value);
        List<Tree> treeList = new ArrayList<>();
        treeList.add(tree);
        initTree(treeList,node.next);
        return tree;
    }


    public void initTree(List<Tree> treeList,Node node){
        List<Tree> tempTreeList = new ArrayList<>();
        for(int i=0;i<treeList.size();i++){
            if(node ==null) {
                return;
            }
            Tree parent = treeList.get(i);

            Tree treeLeftTemp = new Tree(node.value);

            parent.left = treeLeftTemp;
            tempTreeList.add(treeLeftTemp);

            node = node.next;
            if(node==null){
                return;
            }
            Tree treeRightTemp = new Tree(node.value);
            parent.right = treeRightTemp;
            tempTreeList.add(treeRightTemp);
            node = node.next;

            initTree(tempTreeList,node);
        }
    }

    public static void main(String[] args) {
        Tree t = new Link().binaryTree();
        System.out.println(t);

        int a = 'A';
        int b = 'C';
    }
}

class Node{
    Node pre;
    Node next;
    int value;

    public Node(int value){
        this.value = value;
    }

    public String toString(){
        return value+"";
    }

}

class Tree{
    Tree left;
    Tree right;
    int value;

    public Tree(int value){
        this.value=value;
    }

    public String toString(){
        return value+"";
    }
}