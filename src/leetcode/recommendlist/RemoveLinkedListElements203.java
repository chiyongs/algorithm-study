package leetcode.recommendlist;

public class RemoveLinkedListElements203 {

    public class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode prev = head;
        for (ListNode cur = prev; cur != null; cur = cur.next) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
        }
        return head;
    }
}
