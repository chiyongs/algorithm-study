package leetcode.recommendlist

class MergeTwo2DArraysBySummingValues2570 {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val map = mutableMapOf<Int, Int>()
        for (pair in nums1) {
            val key = pair[0]
            val value = pair[1]
            map[key] = map.getOrDefault(key, 0) + value
        }

        for (pair in nums2) {
            val key = pair[0]
            val value = pair[1]
            map[key] = map.getOrDefault(key, 0) + value
        }

        return map.toList().sortedBy { it.first }.map { intArrayOf(it.first, it.second) }.toTypedArray()
    }
}