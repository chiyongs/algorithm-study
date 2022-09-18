package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_2073_수도배관공사 {

    static class Pipe implements Comparable<Pipe> {
        int length;
        int capacity;

        public Pipe(int length, int capacity) {
            this.length = length;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(Pipe o) {
            if(this.capacity == o.capacity) {
                return o.length - this.length;
            }
            return o.capacity - this.capacity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Pipe[] pipes = new Pipe[P];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pipes[i] = new Pipe(L,C);
        }

        Arrays.sort(pipes);

        long totalLength = 0;
        long totalCapacity=0;
        for(int i=0;i<P-1;i++) {
            totalLength = pipes[i].length;
            totalCapacity = pipes[i].capacity;

            for(int j=i+1;j<P;j++) {
                if(totalLength + pipes[j].length > D) {
                    continue;
                } else if(totalLength + pipes[j].length < D) {
                    totalLength += pipes[j].length;
                    totalCapacity = pipes[j].capacity;
                } else {
                    System.out.println(pipes[j].capacity);
                    return;
                }
            }
        }

    }
}
