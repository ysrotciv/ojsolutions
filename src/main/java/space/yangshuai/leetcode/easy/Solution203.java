package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.ListNode;

/**
 * Created by shuai.yang on 2015/5/21.
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        while(head.val == val) {
            head = head.next;
            if (head == null)
                return head;
        }

        ListNode node = head;
        if (node.next == null)
            return node;

        while (true) {

            if (node.next == null)
                break;

            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
