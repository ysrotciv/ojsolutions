package space.yangshuai.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode current = head;

        while (true) {

            if (current.val == current.next.val) {
                if (current.next.next == null) {
                    current.next = null;
                    break;
                } else {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
                if (current.next == null)
                    break;
            }
        }

        return head;
    }
}
