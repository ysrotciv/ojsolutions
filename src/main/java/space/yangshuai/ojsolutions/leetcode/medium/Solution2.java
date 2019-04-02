package space.yangshuai.ojsolutions.leetcode.medium;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1, q = l2, head = new ListNode(0), curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        new Solution2().addTwoNumbers(new ListNode(5), new ListNode(5));
    }

}

