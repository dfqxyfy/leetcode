package com.ccs.lc.doublepointer;

import com.ccs.lc.ListNode;

/**
 * @date 2024/11/21 3:34 PM
 */
public class L206 {
    public ListNode reverseNode(ListNode node){
        ListNode pre = null;
        ListNode head = node;

        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init1();
        ListNode listNode1 = new L206().reverseNode(listNode);
        System.out.println(listNode1.info());
    }

}
