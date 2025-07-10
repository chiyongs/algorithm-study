package leetcode.recommendlist

class CountNumberOfPairsWithAbsoluteDifferenceK2006 {
    fun countKDifference(nums: IntArray, k: Int): Int {
        val pairs = nums.groupBy({it - k}, {it})
        val pairsCount = nums.sumOf {
            pairs.getOrDefault(it, emptyList()).size
        }
        return pairsCount
    }
}