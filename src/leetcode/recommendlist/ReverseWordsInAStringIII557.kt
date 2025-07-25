package leetcode.recommendlist

import java.util.Stack

fun main() {
    println(ReverseWordsInAStringIII557().reverseWords("Let's take LeetCode contest"))
}

class ReverseWordsInAStringIII557 {
    fun reverseWords(s: String): String {
        val stack = Stack<Char>()

        val sb = StringBuilder()
        for (c in s) {
            if (c == ' ') {
                while (stack.isNotEmpty()) {
                    sb.append(stack.pop())
                }
                sb.append(c)
            } else {
                stack.push(c)
            }
        }
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }
        return sb.toString()
    }
}