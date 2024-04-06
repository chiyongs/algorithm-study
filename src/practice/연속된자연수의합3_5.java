package practice;

import java.util.Scanner;

public class 연속된자연수의합3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int sum = 0;
        int lt = 1;
        for(int rt=1;rt<N;rt++) {
            sum += rt;
            if (sum == N) cnt++;
            while(sum >= N) {
                sum -= lt++;
                if (sum == N) cnt++;
            }
        }

        System.out.println(cnt);

//        int cnt = 0;
//        int sum = 1;
//        int lt = 1, rt = 1;
//        while(lt <= N/2 + 1 && rt < N) {
//            if (sum == N) {
//                cnt++;
//                if (rt == N -1) break;
//                sum += ++rt;
//                sum -= lt++;
//            } else if (sum < N) {
//                if (rt == N-1) break;
//                sum += ++rt;
//            } else {
//                sum -= lt++;
//            }
//        }

//        System.out.println(cnt);

    }
}
