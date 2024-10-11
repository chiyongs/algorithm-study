package leetcode.recommendlist;

import java.util.*;

public class BinaryTreePaths257 {

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

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        search(root, new String(), result);
        return result;
    }

    private void search(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
        }
        if (node.left != null) {
            search(node.left, path + node.val + "->", result);
        }
        if (node.right != null) {
            search(node.right, path + node.val + "->", result);
        }

    }
}
