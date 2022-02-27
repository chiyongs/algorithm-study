package boj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author chiyongs
 * @since 2022. 2. 27.
 * @see https://www.acmicpc.net/problem/1244
 * @performance 11700	88
 * @category #구현 #출력형식에 유의하자..
 * @note
 */
public class BOJ_S3_1244_스위치켜고끄기 {
	
	static class Student {
		int gender;
		int no;
		
		public Student(int gender, int no) {
			this.gender = gender;
			this.no = no;
		}

		@Override
		public String toString() {
			return "S[gender=" + gender + ", no=" + no + "]";
		}
		
	}
	
	static int N,switches[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		switches = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Student[] students = new Student[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			students[i] = new Student(gender, no);			
		}
		
		for(int i=0;i<M;i++) {
			if(students[i].gender == 1) {
				List<Integer> baesu = getBaeSu(students[i].no);
				for(int b : baesu) {
					if(switches[b] == 0) switches[b] = 1;
					else switches[b] = 0;
				}
			}
			else if(students[i].gender == 2) {
				List<Integer> checked = check(students[i].no);
				if(checked.size() == 1) {					
					if(switches[students[i].no] == 0) switches[students[i].no] = 1;
					else switches[students[i].no] = 0;
				} else {
					for(int c:checked) {
						if(switches[students[i].no + c] == 0) {
							switches[students[i].no + c] = 1;
							switches[students[i].no - c] = 1;
						} else {
							switches[students[i].no + c] = 0;
							switches[students[i].no - c] = 0;
						}
					}
				}
			}
		}
		
		int[] answer = new int[N];
		System.arraycopy(switches, 1, answer, 0, N);
		
		for(int i=0;i<N;i++) {
			System.out.print(answer[i]+" ");
			if((i+1)%20== 0) System.out.println();
		}
	}
	
	private static List<Integer> check(int num) {
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		for(int i=1;num-i>0&&num+i<=N;i++) {
			int left = switches[num-i];
			int right = switches[num+i];
			
			if(left != right) {				
				break;
			} else {
				temp.add(i);
			}
		}
		return temp;
	}
	
	private static List<Integer> getBaeSu(int num) {
		List<Integer> temp = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(num * i <=N) {
				temp.add(num*i);
			}
		}
		return temp;
	}

}
