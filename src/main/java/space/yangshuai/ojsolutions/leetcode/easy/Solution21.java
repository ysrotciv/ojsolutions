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

        ListNode root, side, main, temp;

        if (l1.val < l2.val) {
            root = main = l1;
            side = l2;
        } else {
            root = main = l2;
            side = l1;
        }


        while (true) {

           if (main.next == null) {
               main.next = side;
               break;
           }

            if (main.next.val > side.val) {
               temp = main.next;
               main.next = side;
               side = temp;
           } else {
               main = main.next;
           }
        }

        return root;
    }

}
