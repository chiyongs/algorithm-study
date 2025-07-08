package leetcode.recommendlist

class CountItemsMatchingARule1773 {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        var cnt = 0
        for(item in items) {
            when(ruleKey) {
                "type" -> {
                    if (item[0] == ruleValue) {
                        cnt++
                    }
                }
                "color" -> {
                    if (item[1] == ruleValue) {
                        cnt++
                    }
                }
                "name" -> {
                    if (item[2] == ruleValue) {
                        cnt++
                    }
                }
            }
        }
        return cnt
    }
}