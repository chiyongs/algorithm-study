package leetcode.recommendlist

class ClearDigits3174 {
    fun clearDigits(s: String): String {
        val deque = ArrayDeque<Char>()
        for (char in s) {
            if (isDigit(char)) {
                if (deque.isNotEmpty()) deque.removeLast()
            } else {
                deque.addLast(char)
            }
        }
        return if (deque.isEmpty()) "" else buildString {
            while (deque.isNotEmpty()) {
                val tmp = deque.removeFirst()
                append(tmp)
            }
        }
    }

    fun isDigit(char: Char) = char in "0123456789"
}