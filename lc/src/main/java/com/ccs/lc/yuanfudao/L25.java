package com.ccs.lc.yuanfudao;

import com.ccs.lc.ListNode;
import javafx.util .Pair;

/**
 * @date 2024/12/2 19:02
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class L25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode resultHead = new ListNode();
        ListNode resultTail = resultHead;

        ListNode temp = head;
        ListNode tHead = new ListNode();
        ListNode tTail = tHead;
        int tLen = 0;
        ListNode nextTail = null;

       while(temp!=null){

           tLen++;
           tTail.next = temp;
           tTail = temp;

           nextTail = temp.next;
           if(tLen == k|| nextTail == null){
               temp.next = null;
               Pair<ListNode, ListNode> listNodeListNodePair = reverseNode(tHead.next, tLen, k);
               resultTail.next = listNodeListNodePair.getKey();
               resultTail = listNodeListNodePair.getValue();
               tLen=0;
               tHead = new ListNode();
               tTail = tHead;
           }
           temp = nextTail;
       }
       return resultHead.next;
    }

    private Pair<ListNode,ListNode > reverseNode(ListNode node, int len, int k){
        if(len<k){
            ListNode tail = node;
            while(tail!=null && tail.next!=null){
                tail = tail.next;
            }
            tail.next = null;
            return new Pair<>(node,tail);
        }
        ListNode head = new ListNode();
        ListNode tail = node;

        while(node!=null){
            ListNode temp = node.next;
            ListNode tempHead = head.next;
            head.next = node;
            node.next = tempHead;
            node = temp;
        }
        tail.next =null;
        return new Pair<>(head.next,tail);
    }

    public static void main(String[] args) {
        ListNode listNode = new L25().reverseKGroup(ListNode.init1(), 2);
        System.out.println(listNode.info());
        listNode = new L25().reverseKGroup(ListNode.init1(), 3);
        System.out.println(listNode.info());
    }
}
