package leetcode.recommendlist;

import java.util.*;

public class BinaryTreePostorderTraversal145 {

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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        travel(root);
        return result;
    }

    void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        travel(node.left);
        travel(node.right);
        result.add(node.val);
    }
}
