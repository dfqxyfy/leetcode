package com.ccs.test;

/**
 * @date 2024/10/24 10:21 PM
 */
public class MyTree {

    public void genTree(Node node , int high){
        if(high<=0){
            return;
        }
        Node left = new Node(high);
        Node right = new Node(high);

        node.left=left;
        node.right=right;
        genTree(left,high-1);
        genTree(right,high-1);
    }


    public static void main(String[] args) {
        Node root = new Node(0);
        new MyTree().genTree(root,5);
        System.out.println(root);
    }
}

class Node{
    Node left;
    Node right;

    int val;

    public Node(int val){
        this.val=val;
    }
}
