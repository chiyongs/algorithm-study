package boj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 3. 31.
 * @see https://www.acmicpc.net/problem/12865
 * @performance 90908	188
 * @category #DP
 * @note
 */
public class BOJ_G5_12865_평범한배낭 {
	
	static class Item {
		int weight, value;
		
		public Item(int w, int v) {
			value = v;
			weight = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Item[] items = new Item[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		long[][] d = new long[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(items[i].weight > j) {
					// i번째 아이템이 현재 가방의 무게보다 무거워서 담지 못할 때
					d[i][j] = d[i-1][j];
				} else {
					// i번째 아이템을 담거나 담지 않을 수 있다.
					// 현재 가방 무게 : j
					// i번째 아이템의 무게를 제외한 가방의 무게 : j - items[i].weight
					// d[i-1][j - items[i].weight] : i-1개의 물건을 가지고 i번째 아이템을 들어갈 수 있는 공간이 남아있는 가방의 최대 가치
					d[i][j] = Math.max(items[i].value + d[i-1][j-items[i].weight], d[i-1][j]);
				}
			}
		}
		
		System.out.println(d[N][K]);

	}

}
