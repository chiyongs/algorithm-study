package leetcode.recommendlist;

public class PartitionList86 {

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

    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0);
        ListNode gt = new ListNode(0);

        ListNode ltp = lt;
        ListNode gtp = gt;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ListNode node = new ListNode(cur.val);
            if (node.val < x) {
                ltp.next = node;
                ltp = ltp.next;
            } else {
                gtp.next = node;
                gtp = gtp.next;
            }
        }
        ltp.next = gt.next;
        return lt.next;
    }
}
