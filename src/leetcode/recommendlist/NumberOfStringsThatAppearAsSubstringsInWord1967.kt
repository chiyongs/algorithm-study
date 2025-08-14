package leetcode.recommendlist

class NumberOfStringsThatAppearAsSubstringsInWord1967 {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.count { word.contains(it) }
    }
}