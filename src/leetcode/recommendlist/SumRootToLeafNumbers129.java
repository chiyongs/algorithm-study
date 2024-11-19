package leetcode.recommendlist;

public class SumRootToLeafNumbers129 {

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

    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sum = 0;
        numbers(root, sb);
        return sum;
    }

    void numbers(TreeNode node, StringBuilder num) {
        if (node == null) {
            return;
        }
        num.append(node.val);
        if (node.left == null && node.right == null) {
            String str = num.toString();
            System.out.println(str);
            sum += Integer.parseInt(str);
        } else {
            numbers(node.left, num);
            numbers(node.right, num);
        }
        num.deleteCharAt(num.length() - 1);
    }
}
