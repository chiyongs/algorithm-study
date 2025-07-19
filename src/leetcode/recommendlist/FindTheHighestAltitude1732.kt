package leetcode.recommendlist

class FindTheHighestAltitude1732 {
    fun largestAltitude(gain: IntArray): Int {
        var max = 0
        var cur = 0

        gain.forEach {
            cur += it
            max = maxOf(max, cur)
        }

        return max
    }
}