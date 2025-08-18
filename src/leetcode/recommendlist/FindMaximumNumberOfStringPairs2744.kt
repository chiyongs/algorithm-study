package leetcode.recommendlist

class FindMaximumNumberOfStringPairs2744 {
    fun maximumNumberOfStringPairs(words: Array<String>): Int {
        val set = mutableSetOf<String>()
        var result: Int = 0
        for (word in words) {
            if (set.contains(word.reversed())) {
                result++
            } else {
                set.add(word)
            }
        }
        return result
    }
}