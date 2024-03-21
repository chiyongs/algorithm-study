package practice;

import java.util.LinkedList;
import java.util.Queue;

public class Tree말난노드까지의가장짧은경로BFS7_10 {

    static class Node {
        int val;
        Node lt,rt;

        Node(int val) {
            this.val = val;
        }
    }

    static Node[] nodes;

    public static void main(String[] args) {
        nodes = new Node[6];
        for (int i=1;i<=5;i++) {
            nodes[i] = new Node(i);
        }
        nodes[1].lt = nodes[2];
        nodes[1].rt = nodes[3];
        nodes[2].lt = nodes[4];
        nodes[2].rt = nodes[5];

        System.out.println(bfs(nodes[1]));
    }

    static int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Node cur = q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return level;
                }
                if (cur.lt != null) q.offer(cur.lt);
                if (cur.rt != null) q.offer(cur.rt);
            }
            level++;
        }
        return level;
    }
}
