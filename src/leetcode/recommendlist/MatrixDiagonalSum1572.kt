package leetcode.recommendlist

class MatrixDiagonalSum1572 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        for (i in mat.indices) {
            sum += (mat[i][i] + mat[mat.lastIndex - i][i])
        }

        if (mat.size % 2 != 0) {
            sum -= mat[mat.lastIndex / 2][mat.lastIndex / 2]
        }

        return sum
    }
}