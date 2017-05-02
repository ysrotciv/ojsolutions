package space.yangshuai.leetcode.easy;

import Common.ListNode;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        if (head.next == head) return true;

        ListNode node = head.next;
        ListNode temp;

        while (true) {
            if (node.next == null) return false;
            if (node.next == head) return true;
            temp = node;
            node = node.next;
            temp.next = head;
        }

    }

}
