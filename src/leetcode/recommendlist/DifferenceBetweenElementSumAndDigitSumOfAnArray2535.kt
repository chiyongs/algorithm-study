package leetcode.recommendlist

class DifferenceBetweenElementSumAndDigitSumOfAnArray2535 {
    fun differenceOfSum(nums: IntArray): Int {
        var elementSum = 0
        var digitSum = 0
        for (num in nums) {
            elementSum += num
            var temp = num
            while (temp >= 10) {
                digitSum += temp % 10
                temp /= 10
            }
            digitSum += temp
        }

        return Math.abs(elementSum - digitSum)
    }
}