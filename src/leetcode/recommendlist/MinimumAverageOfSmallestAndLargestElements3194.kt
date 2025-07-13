package leetcode.recommendlist

import kotlin.math.min

class MinimumAverageOfSmallestAndLargestElements3194 {
    fun minimumAverage(nums: IntArray): Double {
        nums.sort()

        var minAvg = Double.MAX_VALUE

        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val avg = (nums[left] + nums[right]) / 2.0
            minAvg = min(minAvg, avg)
            left++
            right--
        }
        return minAvg
    }
}