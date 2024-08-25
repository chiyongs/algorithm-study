package leetcode.recommendlist;

public class BalancedBinaryTree110 {

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

    private boolean status = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return status;
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1) {
            status = false;
        }
        return Math.max(left, right) + 1;
    }
}
