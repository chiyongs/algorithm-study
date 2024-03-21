package practice;

public class Tree말난노드까지의가장짧은경로DFS7_09 {

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

        System.out.println(dfs(nodes[1], 0));
    }

    static int dfs(Node cur, int cnt) {
        if (cur.lt == null || cur.rt == null) {
            return cnt;
        }
        return Math.min(dfs(cur.lt, cnt + 1), dfs(cur.rt, cnt + 1));
    }
}
