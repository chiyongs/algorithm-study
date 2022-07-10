package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 7. 10.
 * @see https://www.acmicpc.net/problem/1503
 * @performance 12600	340
 * @category #구현
 * @note열
 */
public class BOJ_S3_1503_세수고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        boolean[] arr = new boolean[1002]; // 1001까지 들어올 수 있으므로 1002까지
        for(int i=0;i<M;i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=1001;i++) {
            if(arr[i]) continue;
            for(int j=i;j<=1001;j++) { // 기존에 124를 해봤는데 다시 214를 해볼 필요 X
                if(arr[j]) continue;
                for(int k=j;k<=1001;k++) { // 기존에 124를 해봤는데 142를 해볼 필요 X
                    if(arr[k]) continue;
                    int result = Math.abs(N-(i*j*k));
                    if(result < min) {
                        min = result;
                    }
                }

            }
            if(min == 0) break;
        }

        System.out.println(min);

    }

}
