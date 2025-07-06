package leetcode.recommendlist

import kotlin.math.max

class SumOfVariableLengthSubarrays3427 {
    fun subarraySum(nums: IntArray): Int {
        var sum = 0
        for (idx in nums.indices) {
            val start = max(0, idx - nums[idx])
            for (i in start..idx) {
                sum += nums[i]
            }
        }
        return sum
    }
}