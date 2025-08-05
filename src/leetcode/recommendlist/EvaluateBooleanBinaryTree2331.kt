package leetcode.recommendlist

class EvaluateBooleanBinaryTree2331 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null) {
            return root.`val` == 1
        }

        val lTree = evaluateTree(root.left)
        val rTree = evaluateTree(root.right)

        return if (root.`val` == 2) {
            lTree || rTree
        } else {
            lTree && rTree
        }
    }
}