package leetcode.recommendlist

class CountGoodTriplets1534 {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var triplets = 0
        val size = arr.size
        for (i in 0 until size-2) {
            for (j in i+1 until size-1) {
                if (Math.abs(arr[i] - arr[j]) > a) continue
                for (k in j+1 until size) {
                    if (Math.abs(arr[j] - arr[k]) > b) continue
                    if (Math.abs(arr[i] - arr[k]) <= c) {
                        triplets++
                    }
                }
            }
        }
        return triplets
    }
}