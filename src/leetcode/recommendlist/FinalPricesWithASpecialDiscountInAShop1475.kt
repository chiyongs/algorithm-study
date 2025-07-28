package leetcode.recommendlist

class FinalPricesWithASpecialDiscountInAShop1475 {
    fun finalPrices(prices: IntArray): IntArray {
        val length = prices.size -1
        for (i in 0 until length) {
            var discount = 0
            for (j in i+1..length) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j]
                    break
                }
            }
            prices[i] -= discount
        }
        return prices
    }
}