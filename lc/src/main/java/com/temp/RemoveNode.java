package com.temp;

/**
 * @date 2024/11/19 3:29 PM
 */
public class RemoveNode {

    public Node removeNode(Node head,int value){
        Node tempHead = new Node(0);
        tempHead.next = head;
        Node cur = tempHead;
        while(cur!=null && cur.next!=null){
            if(cur.next.value == value){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3,new Node(1))));
        Node node1 = new RemoveNode().removeNode(node, 1);
        System.out.println(node1);
    }
}
