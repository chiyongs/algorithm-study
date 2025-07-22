package leetcode.recommendlist

class FindThePivotInteger2485 {
    fun pivotInteger(n: Int): Int {
        var left = 1
        var right = n
        while (left <= right) {
            val mid = left + (right - left) / 2
            val leftSum = sum(1, mid)
            val rightSum = sum(mid, n)
            if (leftSum == rightSum) {
                return mid
            } else if (leftSum < rightSum) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }

    fun sum(start: Int, end: Int): Int = (start + end) * (end - start + 1) / 2
}