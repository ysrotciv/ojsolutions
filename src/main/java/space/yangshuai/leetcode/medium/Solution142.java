package space.yangshuai.leetcode.medium;

import space.yangshuai.leetcode.common.ListNode;

/**
 * Created by rotciv on 2017/1/6.
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode walker = head;
        ListNode runner = head;

        while (walker.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) return walker;
        }

        return null;
    }

}
