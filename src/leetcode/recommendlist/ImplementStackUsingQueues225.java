package leetcode.recommendlist;

import java.util.*;

public class ImplementStackUsingQueues225 {
    class MyStack {

        Deque<Integer> deque;

        public MyStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.offer(x);
        }

        public int pop() {
            if (deque.isEmpty()) {
                return 0;
            }
            return deque.pollLast();
        }

        public int top() {
            if (deque.isEmpty()) {
                return 0;
            }
            return deque.peekLast();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
