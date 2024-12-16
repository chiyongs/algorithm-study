package leetcode.recommendlist;

import java.util.*;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {
        ReverseLinkedListII92 r = new ReverseLinkedListII92();
        ListNode head = new ListNode(1);
        ListNode hp = head;
        for (int i=2;i<=5;i++) {
            ListNode node = new ListNode(i);
            hp.next = node;
            hp = node;
        }
        r.reverseBetween(head, 2, 4);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int idx = 0;
        while (idx < left) {
            first = second;
            second = second.next;
            idx++;
        }

        Stack<Integer> stack = new Stack<>();
        while (idx <= right) {
            stack.push(second.val);
            second = second.next;
            idx++;
        }

        ListNode reverse = new ListNode(stack.pop());
        ListNode rp = reverse;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            rp.next = node;
            rp = node;
        }

        first.next = reverse;
        rp.next = second;

        return dummy.next;
    }
}
