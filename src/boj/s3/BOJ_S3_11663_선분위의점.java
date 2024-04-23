package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_11663_선분위의점 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] dots = new int[N];
        for(int i=0;i<N;i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dots);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start > dots[N-1] || end < dots[0]) {
                sb.append(0).append("\n");
                continue;
            }

            int lt = 0;
            int rt = N-1;
            int mid = 0;
            int startDotIdx = 0;
            while(lt <= rt) {
                mid = (lt + rt) / 2;

                if (dots[mid] < start) {
                    lt = mid + 1;
                } else if (dots[mid] > start) {
                    rt = mid - 1;
                    startDotIdx = mid;
                } else {
                    startDotIdx = mid;
                    break;
                }
            }

            lt = 0;
            rt = N-1;
            mid = 0;
            int endDotIdx = 0;
            while(lt <= rt) {
                mid = (lt + rt) / 2;

                if (dots[mid] < end) {
                    endDotIdx = mid;
                    lt = mid + 1;
                } else if (dots[mid] > end) {
                    rt = mid - 1;
                } else {
                    endDotIdx = mid;
                    break;
                }
            }

            sb.append(endDotIdx - startDotIdx + 1).append("\n");
        }
        System.out.print(sb.toString());
    }
}
