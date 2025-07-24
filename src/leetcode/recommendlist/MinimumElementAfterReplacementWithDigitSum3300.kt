package leetcode.recommendlist

class MinimumElementAfterReplacementWithDigitSum3300 {
    fun minElement(nums: IntArray) = nums.minOf { it.toString().sumOf { it.digitToInt() } }
}