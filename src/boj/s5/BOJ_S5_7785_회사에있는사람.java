package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 20.
 * @see https://www.acmicpc.net/problem/7785
 * @performance 58760	1660
 * @category #해시
 * @note 
 */
public class BOJ_S5_7785_회사에있는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String eorl = st.nextToken();
			
			if(eorl.equals("enter")) set.add(name);
			else if(eorl.equals("leave")) set.remove(name);
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list,Collections.reverseOrder());
		
		for(String s : list) {
			System.out.println(s);
		}
	}

}
