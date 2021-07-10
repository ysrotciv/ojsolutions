package space.yangshuai.ojsolutions.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return null;

        if (head.next == null)
            return head;

        if (head.next.next == null) {
            ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }

        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = head.next.next;
        head.next = null;
        current.next = prev;

        if (next.next == null) {
            next.next = current;
            return next;
        }

        while (true) {

            prev = current;

            if (next.next == null) {
                next.next = current;
                return next;
            } else {
                current = next;
                next = next.next;
                current.next = prev;
            }
        }
    }

    public static void main (String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new Solution206().reverseList(l1);
    }
}
