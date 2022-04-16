package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 4. 15.
 * @see https://www.acmicpc.net/problem/13144
 * @performance 36688	324	
 * @category #투포인터
 * @note
 */
public class BOJ_G4_13144_ListOfUniqueNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new HashSet<>();
		int right = 0, left = 0;
		long result = 0;
		while(true) {
            if(right==N) {
                if(left==N) break;
                else {
                    result += (right-left);
                    left++;
                }
            }

            else if(!set.contains(nums[right])) {
            	set.add(nums[right]);
                right++;
            }

            else {
                result += (right-left);
                set.remove(nums[left]);
                left++;
            }
        }

        System.out.println(result);

	}

}
