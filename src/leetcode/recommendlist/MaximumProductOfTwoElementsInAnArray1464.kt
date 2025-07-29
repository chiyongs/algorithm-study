package leetcode.recommendlist

class MaximumProductOfTwoElementsInAnArray1464 {
    fun maxProduct(nums: IntArray): Int {
        var max = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                max = maxOf(max, (nums[i] - 1) * (nums[j] - 1))
            }
        }
        return max
    }
}