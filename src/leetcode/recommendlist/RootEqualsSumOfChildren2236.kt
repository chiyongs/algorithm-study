package leetcode.recommendlist

class RootEqualsSumOfChildren2236 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun checkTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return root.`val` == (root.left!!.`val` + root.right!!.`val`)
    }
}