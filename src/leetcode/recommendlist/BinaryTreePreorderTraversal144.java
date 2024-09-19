package leetcode.recommendlist;

import java.util.*;

public class BinaryTreePreorderTraversal144 {

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

    List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        } else {
            result.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
