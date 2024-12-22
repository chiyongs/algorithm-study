package leetcode.recommendlist;

public class OddEvenLinkedList328 {

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

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddPtr = odd;
        ListNode even = new ListNode(0);
        ListNode evenPtr = even;

        int idx = 1;
        while (head != null) {
            if (idx % 2 == 0) {
                evenPtr.next = head;
                evenPtr = evenPtr.next;
            } else {
                oddPtr.next = head;
                oddPtr = oddPtr.next;
            }
            head = head.next;
            idx++;
        }
        evenPtr.next = null;
        oddPtr.next = even.next;
        return odd.next;
    }
}
