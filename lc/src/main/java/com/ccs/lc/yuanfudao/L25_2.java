package com.ccs.lc.yuanfudao;

import com.ccs.lc.ListNode;

/**
 * @date 2024/12/2 19:02
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class L25_2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode tempTailZero = new ListNode();
        ListNode nextHead = tempTailZero;
        ListNode pre = tempTailZero;
        int i = 0;
        while(temp!=null){
            if(i%k == 0){
                nextHead = pre;
                pre = temp;
            }
            i++;
            ListNode next = temp.next;
            temp.next = nextHead.next;
            nextHead.next = temp;
            temp  = next;
        }
        return tempTailZero.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new L25_2().reverseKGroup(ListNode.init1(), 2);
        System.out.println(listNode.info());
        listNode = new L25_2().reverseKGroup(ListNode.init1(), 3);
        System.out.println(listNode.info());
    }
}
