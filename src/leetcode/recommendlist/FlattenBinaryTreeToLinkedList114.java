package leetcode.recommendlist;

public class FlattenBinaryTreeToLinkedList114 {

    public class TreeNode {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
