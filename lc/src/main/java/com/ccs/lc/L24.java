package com.ccs.lc;

/**
 * @date 2024/11/19 5:56 PM
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        ListNode tempHead = new ListNode();
        ListNode he = tempHead;
        tempHead.next = head;
        while(tempHead!=null && tempHead.next!=null){
            if(tempHead.next.next!=null){
                ListNode temp = tempHead.next.next.next;
                ListNode firstNode = tempHead.next;
                ListNode secondNode = tempHead.next.next;

                secondNode.next = firstNode;
                firstNode.next = temp;
                tempHead.next = secondNode;

            }
            tempHead = tempHead.next.next;
        }
        return he.next;

    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init1();
        ListNode listNode1 = new L24().swapPairs(listNode);
        System.out.println(listNode1);
    }
}
