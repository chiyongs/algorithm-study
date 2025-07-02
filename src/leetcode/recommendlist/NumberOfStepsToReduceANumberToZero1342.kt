package leetcode.recommendlist

class NumberOfStepsToReduceANumberToZero1342 {
    fun numberOfSteps(num: Int): Int {
        var steps = 0
        var number = num
        while (number > 0) {
            if (number % 2 == 0) number /= 2 else number--
            steps++
        }
        return steps
    }
}