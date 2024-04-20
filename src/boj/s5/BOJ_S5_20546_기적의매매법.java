package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_20546_기적의매매법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cache = Integer.parseInt(br.readLine());
        int[] prices = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<14;i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int j = joonhyun(cache, prices);
        int s = sungmin(cache, prices);
        if (j > s) {
            System.out.println("BNP");
        } else if (j < s) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static int joonhyun(int cache, int[] prices) {
        int money = cache;
        int cnt = 0;
        for(int i=0;i<prices.length;i++) {
            if (money >= prices[i]) {
                cnt = money / prices[i];
                money = money % prices[i];
            }
        }

        return prices[prices.length-1] * cnt + money;
    }

    static int sungmin(int cache, int[] prices) {
        int downCnt = 0;
        int upCnt = 0;
        int prev = prices[0];

        int cnt = 0;
        int rest = cache;
        for(int i=1;i<prices.length;i++) {
            if (prev < prices[i]) {
                upCnt++;
                downCnt = 0;
            } else if (prev > prices[i]){
                downCnt++;
                upCnt = 0;
            } else {
                downCnt = 0;
                upCnt = 0;
            }
            if (downCnt == 3) {
                cnt += rest / prices[i];
                rest = rest % prices[i];
                downCnt--;
            }
            if (upCnt == 3) {
                rest += prices[i] * cnt;
                cnt = 0;
                upCnt--;
            }
            prev = prices[i];
        }

        return rest + prices[prices.length-1] * cnt;
    }
}
