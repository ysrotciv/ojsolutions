package space.yangshuai.ojsolutions.leetcode.common;

/**
 * Definition for singly-linked list.
 * 237
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode parse(String raw) {
        raw = raw.trim().substring(1, raw.length() - 1);
        String[] arr = raw.split(",");
        ListNode head = new ListNode(Integer.parseInt(arr[0]));
        ListNode pre = head;
        for (int i = 1; i <arr.length; i++) {
            ListNode current = new ListNode(Integer.parseInt(arr[i]));
            pre.next = current;
            pre = current;
        }
        return head;
    }
}
