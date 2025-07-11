package leetcode.recommendlist

class MinimumNumberGame2974 {
    fun numberGame(nums: IntArray): IntArray {
        return nums.sort().let {
            IntArray(nums.size) {
                if (it % 2 == 0) nums[it + 1]
                else nums[it - 1] }
        }
    }
}