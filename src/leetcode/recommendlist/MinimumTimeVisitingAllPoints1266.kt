package leetcode.recommendlist

import kotlin.math.abs

class MinimumTimeVisitingAllPoints1266 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        return (1 until points.size).sumOf {
            maxOf(
                abs(points[it][0] - points[it-1][0]) ,
                abs(points[it][1] - points[it-1][1])
            )
        }
    }
}