package leetcode.recommendlist;

import java.util.*;

public class SecondMinimumNodeInABinaryTree671 {
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


    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        boolean isChecked = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.val <= min) {
                    min = cur.val;
                } else if (cur.val <= secondMin) {
                    secondMin = cur.val;
                    isChecked = true;
                }

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }

        return secondMin == Integer.MAX_VALUE && !isChecked ? -1 : secondMin;
    }

}
