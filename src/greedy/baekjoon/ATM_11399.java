package greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM_11399 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] timeList = new int[1001];
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);
    
    while(N-- > 0) {
      timeList[Integer.parseInt(st.nextToken())]++;
    }
    int prev = 0;
    int sum = 0;
    for (int i = 0; i < 1001; i++) {
      while (timeList[i]-- > 0) {
        sum += (i + prev);
        prev += i;
      }
    }
    System.out.println(sum);

  }
}
