package leetcode.recommendlist

class FindCommonElementsBetweenTwoArrays2958 {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
        return intArrayOf(nums1.count { it in nums2 }, nums2.count {it in nums1})
    }
}