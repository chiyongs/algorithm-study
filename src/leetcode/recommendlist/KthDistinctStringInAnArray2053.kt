package leetcode.recommendlist

class KthDistinctStringInAnArray2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val cnts = LinkedHashMap<String, Int>()
        for (str in arr) {
            cnts[str] = (cnts[str] ?: 0) + 1
        }
        val distincts = cnts.filter { (k, v) -> v == 1}.keys.toList()
        return if (k > distincts.size) {
            ""
        } else {
            distincts[k - 1]
        }
    }
}