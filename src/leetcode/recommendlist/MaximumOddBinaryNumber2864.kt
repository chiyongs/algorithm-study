package leetcode.recommendlist

class MaximumOddBinaryNumber2864 {
    fun maximumOddBinaryNumber(s: String): String {
        return s.count { it == '1'}
            .let { "1".repeat(it-1) + "0".repeat(s.length - it) + "1"}
    }
}