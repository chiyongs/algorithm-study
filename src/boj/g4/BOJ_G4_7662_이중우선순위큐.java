package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author chiyongs
 * @since 2022. 4. 26.
 * @see https://www.acmicpc.net/problem/7662
 * @performance 438712	2340
 * @category #우선순위 큐 #TreeMap
 * @note key에 대한 갯수를 value에 담는다.
 */
public class BOJ_G4_7662_이중우선순위큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> tmap = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if (command == 'I') {
					// 트리맵에 존재하면 해당 value에 +1 , 존재하지 않으면 value = 1
					tmap.put(num, tmap.getOrDefault(num, 0)+1);
				} else {
					if(tmap.isEmpty()) continue;
					if(num == -1) {
						num = tmap.firstKey(); // 제일 작은 원소
					} else {
						num = tmap.lastKey(); // 제일 큰 원소
					}

					if(tmap.put(num, tmap.get(num) - 1) == 1) {
						// put 메서드는 해당 키에 담겨있던 value를 리턴한다.
						// 해당 키의 값을 하나 줄인다. value - 1
						// 해당 value가 1이라면 1개만 있는 것이므로 remove
						tmap.remove(num);
					}
				}
			}

			if (tmap.isEmpty())
				System.out.println("EMPTY");
			else {
				System.out.println(tmap.lastKey() + " " + tmap.firstKey());
			}
		}

	}

}
