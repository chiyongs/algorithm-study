package leetcode.recommendlist;

import java.util.*;

public class MaximumDepthOfNaryTree559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;

        List<Node> children = root.children;
        for (int i=0;i<children.size();i++) {
            Node cur = children.get(i);
            depth = Math.max(depth, maxDepth(cur) + 1);
        }
        return depth;
    }
}
