package leetcode.recommendlist

class SnakeInMatrix3248 {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        var answer = 0
        commands.forEach {
            when (it) {
                "UP" -> answer -= n
                "RIGHT" -> answer += 1
                "DOWN" -> answer += n
                "LEFT" -> answer -= 1
            }
        }
        return answer
    }
}