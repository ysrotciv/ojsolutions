package space.yangshuai.ojsolutions.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.ListNode;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode temp;

        ListNode newNode = null;
        if (l1.val < l2.val) {
            temp = l1;
            newNode = l1;
            l1 = l1.next;
        } else {
            temp = l2;
            newNode = l2;
            l2 = l2.next;
        }


        while (true) {

            if (l1 == null && l2 == null)
                break;

            if (l2 == null) {
                newNode = addNewNode(newNode, l1.val);
                l1 = l1.next;
            } else if (l1 == null) {
                newNode = addNewNode(newNode, l2.val);
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                newNode = addNewNode(newNode, l1.val);
                l1 = l1.next;
            } else {
                newNode = addNewNode(newNode, l2.val);
                l2 = l2.next;
            }
        }

        return temp;
    }

    private ListNode addNewNode(ListNode pre, int val) {
        ListNode node = new ListNode(val);
        pre.next = node;
        return node;
    }
}
