package leetcode.recommendlist;

public class RemoveDuplicatesFromSortedList83 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int number = head.val;
        ListNode prev = head;
        for(ListNode iter = head.next; iter != null ;iter=iter.next) {
            int curNum = iter.val;
            if (curNum == number) {
                prev.next = iter.next;
            } else {
                number = iter.val;
                prev = iter;
            }
        }
        return head;
    }
}
