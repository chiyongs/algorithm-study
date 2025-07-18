package leetcode.recommendlist

class CheckIfTheSentenceIsPangram1832 {
    fun checkIfPangram(sentence: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        for (ch in sentence) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }
        return map.size == 26
    }
}