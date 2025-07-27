package leetcode.recommendlist

fun main() {
    val f = FindMissingAndRepeatedValues2965()
    f.findMissingAndRepeatedValues(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2)))
}

class FindMissingAndRepeatedValues2965 {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val totalSize = grid.size * grid.size

        val arr = IntArray(totalSize+1)

        for (array in grid) {
            for (value in array) {
                arr[value]++
            }
        }

        val result = IntArray(2)
        for ((idx, freq) in arr.withIndex()) {
            if (idx == 0) continue
            when (freq) {
                2 -> result[0] = idx
                0 -> result[1] = idx
            }
        }
        return result
    }
}