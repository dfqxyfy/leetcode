package com.ccs.lc;

/**
 * @date 2024/11/19 3:46 PM
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode tempHead = new ListNode();

        while(head!=null){
            ListNode suffix = tempHead.next;
            ListNode temp = head;
            head=head.next;
            tempHead.next = temp;
            temp.next =suffix;
        }

        return tempHead.next;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode cur = head;

        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init1();
        //ListNode listNode1 = new L206().reverseList(listNode);
        ListNode listNode2 = new L206().reverseList2(listNode);
        System.out.println(listNode2);
    }
}
