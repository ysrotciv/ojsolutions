package space.yangshuai.ojsolutions.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;

public class Solution234 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre, cur = null;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = cur;
            cur = slow;
            slow = slow.next;
            cur.next = pre;
        }

        ListNode left, right;
        right = slow.next;
        if (fast.next != null) {
            left = slow;
            left.next = cur;
        } else {
            left = cur;
        }

        do {
            if (left.val != right.val) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        } while (left.next != null);
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parse("[1,2]");
        new Solution234().isPalindrome(head);
    }

}
