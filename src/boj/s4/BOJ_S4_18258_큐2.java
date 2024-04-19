package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_18258_큐2 {

    public static void main(String[] args) throws IOException {
        int[] q = new int[2000001];
        int front = 0;
        int rear = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++) {
            String op = br.readLine();
            if (op.contains("push")) {
                int num = Integer.parseInt(op.split(" ")[1]);
                q[rear++] = num;
            } else if (op.contains("pop")) {
                if (front == rear) sb.append(-1).append("\n");
                else sb.append(q[front++]).append("\n");
            } else if (op.contains("size")) {
                sb.append(rear - front).append("\n");
            } else if (op.contains("empty")) {
                if (front == rear) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (op.contains("front")) {
                if (front == rear) sb.append("-1").append("\n");
                else sb.append(q[front]).append("\n");
            } else if (op.contains("back")) {
                if (front == rear) sb.append("-1").append("\n");
                else sb.append(q[rear-1]).append("\n");
            }
        }

        System.out.print(sb.toString());

    }
}
