package leetcode.recommendlist

class CheckIfTwoStringArraysAreEquivalent1662 {
    fun arrayStringsAreEqualV1(word1: Array<String>, word2: Array<String>): Boolean {
        var str1 = ""
        var str2 = ""
        for (w1 in word1) {
            str1 += w1
        }
        for (w2 in word2) {
            str2 += w2
        }

        return str1 == str2
    }

    fun arrayStringsAreEqualV2(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.joinToString("") == word2.joinToString("")
    }

    fun arrayStringsAreEqualV3(word1: Array<String>, word2: Array<String>): Boolean {
        return concatWords(word1) == concatWords(word2)
    }

    private fun concatWords(words: Array<String>): String {
        return StringBuilder().apply {
            words.forEach {
                append(it)
            }
        }.toString()
    }
}