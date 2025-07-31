package leetcode.recommendlist

class CounterAsterisks2315 {
    fun countAsterisks(s: String): Int {
        var balance = 0
        var counter = 0

        for (ch in s) {
            when {
                ch == '|' && balance == 0 -> {
                    balance++
                }
                ch == '|' && balance > 0 -> {
                    balance--
                }
                balance == 0 && ch == '*' -> {
                    counter++
                }
            }
        }
        return counter
    }
}