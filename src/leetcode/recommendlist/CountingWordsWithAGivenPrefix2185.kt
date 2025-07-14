package leetcode.recommendlist

class CountingWordsWithAGivenPrefix2185 {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var cnt = 0
        for (word in words) {
            if (word.startsWith(pref)) {
                cnt++
            }
        }
        return cnt
    }
}