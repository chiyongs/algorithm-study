package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_9019_DSLR {
    static class Register {
        int number;
        int[] numArr;
        List<Character> commands;

        Register(int n) {
            this.number = n;
            this.numArr = toArray(number);
            this.commands = new ArrayList<>();
        }

        Register(int n, List<Character> commands, Character command) {
            this.number = n;
            this.numArr = toArray(number);
            this.commands = new ArrayList<>(commands);
            this.commands.add(command);
        }
    }

    static int A, B;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            visited[A] = true;
            Register register = bfs(new Register(A));
            for(char c : register.commands) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static Register bfs(Register register) {
        Queue<Register> q = new LinkedList<>();
        q.offer(register);

        while(!q.isEmpty()) {
            Register cur = q.poll();

            for(int i=0;i<4;i++) {
                if (i==0) {
                    int result = D(cur.number);
                    if (visited[result]) continue;
                    visited[result] = true;
                    Register r = new Register(result, cur.commands, 'D');
                    if (result == B) return r;
                    q.offer(r);
                } else if (i==1) {
                    int result = S(cur.number);
                    if (visited[result]) continue;
                    visited[result] = true;
                    Register r = new Register(result, cur.commands, 'S');
                    if (result == B) return r;
                    q.offer(r);
                } else if (i==2) {
                    int result = L(cur.number);
                    if (visited[result]) continue;
                    visited[result] = true;
                    Register r = new Register(result, cur.commands, 'L');
                    if (r.number == B) return r;
                    q.offer(r);
                } else {
                    int result = R(cur.number);
                    if (visited[result]) continue;
                    visited[result] = true;
                    Register r = new Register(result, cur.commands, 'R');
                    if (r.number == B) return r;
                    q.offer(r);
                }
            }
        }
        return register;
    }

    static int D(int num) {
        num *= 2;
        if (num > 9999) {
            num %= 10000;
        }
        return num;
    }

    static int S(int num) {
        if (num == 0) num = 9999;
        else num--;
        return num;
    }

    static int L(int num) {
        int[] arr = toArray(num);
        int tmp = arr[0];
        for(int i=0;i<3;i++) {
            arr[i] = arr[i+1];
        }
        arr[3] = tmp;
        return toNumber(arr);
    }

    static int R(int num) {
        int[] arr = toArray(num);
        int tmp = arr[3];
        for(int i=3;i>0;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = tmp;
        return toNumber(arr);
    }

    static int[] toArray(int number) {
        int[] arr = new int[4];
        int idx = 3;
        while(number >= 0 && idx > 0) {
            arr[idx--] = number % 10;
            number /= 10;
        }

        arr[0] = number;
        return arr;
    }

    static int toNumber(int[] array) {
        if (array.length < 1) return 0;
        int num = array[0];
        for(int i=1;i<array.length;i++) {
            num = num * 10 + array[i];
        }
        return num;
    }
}
