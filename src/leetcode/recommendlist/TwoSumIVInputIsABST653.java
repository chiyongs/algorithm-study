package leetcode.recommendlist;

import java.util.*;

public class TwoSumIVInputIsABST653 {
    Set<Integer> set = new HashSet<>();

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

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
