package space.yangshuai.ojsolutions.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;

public class Solution876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            return slow.next;
        }
        return slow;
    }

}
