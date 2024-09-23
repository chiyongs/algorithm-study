package leetcode.recommendlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStack155 {
    class MinStack {

        Stack<Node> stack;
        Node minNode;

        class Node {
            int val;
            Node nextMin;

            Node(int val) {
                this.val = val;
            }
        }

        public MinStack() {
            stack = new Stack<>();
            minNode = new Node(Integer.MAX_VALUE);
        }

        public void push(int val) {
            Node node = new Node(val);
            stack.push(node);
            if (minNode.val > val) {
                node.nextMin = minNode;
                minNode = node;
            }
        }

        public void pop() {
            Node node = stack.pop();
            if (node == minNode) {
                minNode = node.nextMin;
            }
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return minNode.val;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
