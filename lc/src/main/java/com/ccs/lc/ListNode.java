package com.ccs.lc;

/**
 * @date 2024/11/19 3:47 PM
 * Definition for singly-linked list
 */
public class ListNode {

    int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode init1(){
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        return node;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +

                '}';
    }

    public String info(){

        StringBuilder strb = new StringBuilder(this.val+"");
        ListNode node = this;
        while(node.next!=null){
            strb.append(" -> "+node.next.val);
            node = node.next;
        }
        return strb.toString();
    }

    public ListNode mock1(){
        return new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
    }
}
