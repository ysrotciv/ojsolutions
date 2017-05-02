package space.yangshuai.leetcode.easy;

import Common.ListNode;

/**
 * Created by Administrator on 2015/12/19.
 */
public class Solution237 {
    public class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
