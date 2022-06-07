package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chiyongs
 * @since 2022. 5. 22.
 * @see https://www.acmicpc.net/problem/1744
 * @performance 11520	76
 * @category #그리디
 * @note 
 * 		 
 */
public class BOJ_G4_1744_수묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> positive = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		List<Integer> negative = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 1) positive.add(num);
			else if(num == 1) one.add(num);
			else if(num == 0) zero.add(num);
			else negative.add(num);
		}
		
		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negative);
		
		int sum = 0;
		if(positive.size() % 2 == 0 && negative.size() % 2 == 0) {
			for(int i=0;i<positive.size()-1;i+=2) {
				sum += (positive.get(i)*positive.get(i+1));
			}
			for(int i=0;i<negative.size()-1;i+=2) {
				sum += (negative.get(i)*negative.get(i+1));
			}
		} else if(positive.size() % 2 == 0 && negative.size() % 2 == 1) {
			if(zero.isEmpty()) {
				for(int i=0;i<positive.size()-1;i+=2) {
					sum += (positive.get(i)*positive.get(i+1));
				}
				for(int i=0;i<negative.size()-1;i+=2) {
					sum += (negative.get(i)*negative.get(i+1));
				}
				sum += negative.get(negative.size()-1);
			} else {
				for(int i=0;i<positive.size()-1;i+=2) {
					sum += (positive.get(i)*positive.get(i+1));
				}
				for(int i=0;i<negative.size()-1;i+=2) {
					sum += (negative.get(i)*negative.get(i+1));
				}
			}
			
		} else if(positive.size() % 2 == 1 && negative.size() % 2 == 0) {
			for(int i=0;i<positive.size()-1;i+=2) {
				sum += (positive.get(i)*positive.get(i+1));
			}
			for(int i=0;i<negative.size()-1;i+=2) {
				sum += (negative.get(i)*negative.get(i+1));
			}
			sum += positive.get(positive.size()-1);
		} else {
			if(zero.isEmpty()) {
				for(int i=0;i<positive.size()-1;i+=2) {
					sum += (positive.get(i)*positive.get(i+1));
				}
				for(int i=0;i<negative.size()-1;i+=2) {
					sum += (negative.get(i)*negative.get(i+1));
				}
				sum += negative.get(negative.size()-1) + positive.get(positive.size()-1);
			} else {
				for(int i=0;i<positive.size()-1;i+=2) {
					sum += (positive.get(i)*positive.get(i+1));
				}
				for(int i=0;i<negative.size()-1;i+=2) {
					sum += (negative.get(i)*negative.get(i+1));
				}
				sum += positive.get(positive.size()-1);
			}
		}
		
		for(int i=0;i<one.size();i++) {
			sum += one.get(i);
		}
		
		System.out.println(sum);

	}

}
