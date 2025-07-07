package leetcode.recommendlist

class ShuffleString1528 {
    fun restoreString(s: String, indices: IntArray): String {
        var result = ""
        val resArray = Array(indices.size) { it.toString() }
        for (i in s.indices) {
            resArray[indices[i]] = s[i].toString()
        }
        resArray.forEach {
            result += it
        }

        return result
    }
}