package leetcode.recommendlist

class FindTheIntegerAddedToArrayI3131 {
    fun addedInteger(nums1: IntArray, nums2: IntArray): Int {
        return nums2.max() - nums1.max()
    }
}