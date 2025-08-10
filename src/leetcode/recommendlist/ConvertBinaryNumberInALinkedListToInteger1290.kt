package leetcode.recommendlist

class ConvertBinaryNumberInALinkedListToInteger1290 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun getDecimalValue(head: ListNode?): Int {
        var sum = 0
        var current = head
        while (current != null) {
            sum = (sum shl 1) or current.`val`
            current = current.next
        }
        return sum
    }
}