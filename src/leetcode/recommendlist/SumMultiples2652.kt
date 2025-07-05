package leetcode.recommendlist

class SumMultiples2652 {

    var visited: BooleanArray = booleanArrayOf()
    var sum = 0

    fun sumOfMultiples(n: Int): Int {
        visited = BooleanArray(n+1)
        visit(3, n)
        visit(5, n)
        visit(7, n)
        return sum
    }

    private fun visit(divisible: Int, n: Int) {
        for (i in divisible..n step divisible) {
            if (!visited[i]) {
                visited[i] = true
                sum += i
            }
        }
    }
}