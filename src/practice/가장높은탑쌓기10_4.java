package practice;

import java.util.*;

public class 가장높은탑쌓기10_4 {

    static class Block implements Comparable<Block>{
        int size, weight, height;

        Block(int s, int h, int w) {
            this.size = s;
            this.height = h;
            this.weight = w;
        }

        @Override
        public int compareTo(Block o) {
            return o.size - this.size;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();

        Block[] blocks = new Block[N];
        for (int i=0;i<N;i++) {
            blocks[i] = new Block(in.nextInt(), in.nextInt(), in.nextInt());
        }

        Arrays.sort(blocks);

        int[] dp = new int[N];
        dp[0] = blocks[0].height;

        int max = 0;
        for(int i=1;i<N;i++) {
            dp[i] = blocks[i].height;
            for(int j=i-1;j>=0;j--) {
                if (blocks[j].weight > blocks[i].weight) {
                    dp[i] = Math.max(dp[i], dp[j] + blocks[i].height);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}