package leetcode.recommendlist

class SortingTheSentence1859 {
    fun sortSentence(s: String): String {
        return s.split(" ").sortedBy { it.last() }.joinToString(" ") { it.dropLast(1) }
    }

}