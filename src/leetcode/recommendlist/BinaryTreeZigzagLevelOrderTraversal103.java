package leetcode.recommendlist;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                values.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (level % 2 != 0) {
                Collections.reverse(values);
            }
            result.add(values);
            level++;
        }
        return result;
    }
}
