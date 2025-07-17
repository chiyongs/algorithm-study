package leetcode.recommendlist

class FindFirstPalindromicStringInTheArray2108 {
    fun firstPalindrome(words: Array<String>): String {
        for (word in words) {
            if (isPalindrome(word)) return word
        }
        return ""
    }

    private fun isPalindrome(word: String): Boolean {
        var left = 0
        var right = word.length - 1

        while (left < right) {
            if (word[left] != word[right]) {
                return false
            } else {
                left++
                right--
            }
        }
        return true
    }
}