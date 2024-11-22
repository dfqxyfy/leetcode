package com.ccs.lc;

/**
 * @date 2024/11/19 6:54 PM
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class L19 {

    public ListNode removeNode(ListNode head,int target){
        ListNode fast = head;
        ListNode slow = null;
        ListNode slowpre = null;
        int n = 0;
        while(fast != null){
            if(slow!=null){
                slowpre=slow;
                slow=slow.next;
            }
            n++;
            if(n==target){
                slow = head;
            }
            fast=fast.next;
        }
        if(slowpre!=null && slowpre.next!=null){
            slowpre.next = slowpre.next.next;
        }else if(slowpre==null && slow!=null){
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init1();
        System.out.println(listNode.info());
        ListNode listNode1 = new L19().removeNode(listNode, 4);
        System.out.println(listNode1.info());
    }
}
