package leetcode.recommendlist;

import java.util.*;

public class AddTwoNumbersII445 {

    class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (ListNode cur = l1; cur != null; cur = cur.next) {
            s1.push(cur.val);
        }
        for (ListNode cur = l2; cur != null; cur = cur.next) {
            s2.push(cur.val);
        }

        ListNode head = null;
        int upper = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int n1 = s1.pop();
            int n2 = s2.pop();

            int sum = n1 + n2 + upper;
            if (sum >= 10) {
                upper = 1;
                sum = sum % 10;
            } else {
                upper = 0;
            }

            ListNode node = new ListNode(sum);
            if (head != null) {
                node.next = head;
            }
            head = node;
        }

        while (!s1.isEmpty()) {
            int n1 = s1.pop();
            int sum = n1 + upper;

            if (sum >= 10) {
                upper = 1;
                sum %= 10;
            } else {
                upper = 0;
            }
            ListNode node = new ListNode(sum);
            if (head != null) {
                node.next = head;
            }
            head = node;
        }

        while (!s2.isEmpty()) {
            int n2 = s2.pop();
            int sum = n2 + upper;

            if (sum >= 10) {
                upper = 1;
                sum %= 10;
            } else {
                upper = 0;
            }
            ListNode node = new ListNode(sum);
            if (head != null) {
                node.next = head;
            }
            head = node;
        }

        if (upper == 1) {
            ListNode node = new ListNode(upper);
            if (head != null) {
                node.next = head;
            }
            head = node;
        }
        return head;
    }
}
