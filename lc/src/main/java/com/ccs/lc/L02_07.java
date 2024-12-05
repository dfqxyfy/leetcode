package com.ccs.lc;



/**
 * @date 2024/11/19 10:51 PM
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class L02_07 {
    public ListNode samepleNode(ListNode l1, ListNode l2){
        ListNode t1 = l1;
        ListNode t2 = l2;
        boolean nouset1 = true;
        boolean nouset2 = true;

        while(t1!=null && t2!=null){
            if(t1 == t2){
                return t1;
            }
            t1=t1.next;
            t2=t2.next;

            if(t1==null && nouset1){
                t1=l2;
                nouset1 = false;
            }
            if(t2==null && nouset2){
                t2=l1;
                nouset2= false;
            }

        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {
        ListNode tail = new ListNode(3,new ListNode(4,new ListNode(5)));

        ListNode l1 = new ListNode(1,new ListNode(2));
//        l1.next.next = tail;
        ListNode l2 = new ListNode(11,new ListNode(2,new ListNode(3)));
//        l2.next.next.next = tail;

        System.out.println(new L02_07().samepleNode(l1,l2));


        System.out.println(new L02_07().getIntersectionNode(l1,l2));

    }
}
