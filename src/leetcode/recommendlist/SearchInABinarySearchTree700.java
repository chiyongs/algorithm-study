package leetcode.recommendlist;

public class SearchInABinarySearchTree700 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
