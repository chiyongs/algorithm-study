package leetcode.recommendlist

class DecodeTheMessage2325 {

    fun decodeMessage(key: String, message: String): String {
        val map = mutableMapOf<Char, Char>()
        var cur = 'a'
        for (c in key) {
            if (map.containsKey(c) || c == ' ') {
                continue
            }
            map[c] = cur
            cur++
        }

        var sb = StringBuilder()
        for (m in message) {
            val value = if (map.containsKey(m)) map[m]!! else m
            sb.append(value)
        }
        return sb.toString()
    }
}