package space.yangshuai.ojsolutions.leetcode.medium;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;


public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        while (n >= 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
