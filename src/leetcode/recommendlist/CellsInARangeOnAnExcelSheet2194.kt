package leetcode.recommendlist

class CellsInARangeOnAnExcelSheet2194 {
    fun cellsInRange(s: String) = mutableListOf<String>().apply {
        (s.first()..s[3]).forEach {
            for (i in Character.getNumericValue(s[1])..Character.getNumericValue(s.last())) {
                add("$it$i")
            }
        }
    }
}