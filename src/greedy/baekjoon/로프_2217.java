package greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프_2217 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int w = Integer.MIN_VALUE;
    for(int i=N-1;i>=0;i--) {
      w = Math.max(w, arr[i]*(N-i));
    }
    System.out.println(w);
  }
}
