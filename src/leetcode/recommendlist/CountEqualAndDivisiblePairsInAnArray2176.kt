package leetcode.recommendlist

class CountEqualAndDivisiblePairsInAnArray2176 {
    fun countPairs(nums: IntArray, k: Int): Int {
        var cnt = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                if (nums[i] == nums[j]) {
                    val mul = i * j
                    if (mul % k == 0) {
                        cnt++
                    }
                }
            }
        }
        return cnt
    }
}