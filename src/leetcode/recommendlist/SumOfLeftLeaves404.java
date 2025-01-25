package leetcode.recommendlist;

public class SumOfLeftLeaves404 {

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

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLeftLeafValue(root, false);
        return sum;
    }

    void getLeftLeafValue(TreeNode node, boolean isLeft) {
        if (node.left == null
                && node.right == null) {
            if (isLeft) {
                sum += node.val;
            }
            return;
        }

        if (node.left != null) {
            getLeftLeafValue(node.left, true);
        }

        if (node.right != null) {
            getLeftLeafValue(node.right, false);
        }
    }
}
