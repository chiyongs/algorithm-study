package leetcode.recommendlist

class ReplaceAllDigitsWithCharacters1844 {
    fun replaceDigits(s: String): String {
        val sb = StringBuilder()
        var prev: Char = 'a'
        for ((idx, ch) in s.withIndex()) {
            if (idx % 2 != 0) {
                prev += ch.digitToInt()
            } else {
                prev = ch
            }
            sb.append(prev)
        }
        return sb.toString()
    }
}