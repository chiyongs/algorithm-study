package leetcode.recommendlist

import kotlin.math.min

class MinimumCostToReachEveryPosition3502 {
    class Solution {
        fun minCosts(cost: IntArray): IntArray {
            val result = IntArray(cost.size)
            var cur = Integer.MAX_VALUE

            for (i in 0 until cost.size) {
                cur = min(cur, cost[i])

                result[i] = cur
            }

            return result
        }
    }
}