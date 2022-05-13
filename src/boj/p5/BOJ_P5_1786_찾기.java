package boj.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyongs
 * @since 2022. 5. 13.
 * @see https://www.acmicpc.net/problem/1786
 * @performance 68596	500
 * @category #KMP
 * @note 
 */
public class BOJ_P5_1786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int tlength = T.length;
        int plength = P.length;
        
        int[] pi = new int[plength];
        
        for(int i=1,j=0;i<plength;i++) {
            while(j>0 && P[i]!=P[j]) j = pi[j-1];
            
            if(P[i]==P[j]) pi[i] = ++j;
            else pi[i] = 0;
        }
        
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0,j=0;i<tlength;i++) {
            while(j>0 && T[i]!=P[j]) j = pi[j-1];
            
            if(T[i]==P[j]) {
                if(j==plength-1) {
                    cnt++;
                    list.add((i+1)-plength);
                    j=pi[j];
                } else j++;
            }
        }
        
        System.out.println(cnt);
        if(cnt > 0) {
            for(int i=0;i<list.size();i++) {
                sb.append(list.get(i)+1).append(" ");
            }
        }
        System.out.println(sb);

	}

}
