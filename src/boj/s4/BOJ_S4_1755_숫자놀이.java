package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S4_1755_숫자놀이 {

	static class MyNum implements Comparable<MyNum> { // 원래 숫자와 숫자 단위로 하나씩 영어로 읽은 것을 가지는 MyNum 클래스
		int number; // 원래 숫자
		String str; // 숫자 단위로 하나씩 읽은 영어

		@Override
		public int compareTo(MyNum o) { // Comparable의 compareTo 메서드를 오버라이딩
			return this.str.compareTo(o.str); // 숫자 단위로 하나씩 읽은 영어를 사전 순으로 정렬
		}
	}

	static String[] strs = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; // 숫자 단위로																											// 하나씩
																												// 읽을 때
																												// 대칭되는
																												// 영어들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 띄어쓰기를 구분자로 토큰을 얻기 위한 StringTokenizer 생성
		StringBuilder sb = new StringBuilder(); // 출력을 저장하고 한 번에 출력을 하기 위한 StringBuilder 생성
		int M = Integer.parseInt(st.nextToken()); // 정수 M 저장
		int N = Integer.parseInt(st.nextToken()); // 정수 N 저장

		PriorityQueue<MyNum> pq = new PriorityQueue<>(); // MyNum을 원소로 하는 우선순위 큐 생성 -> 숫자 단위로 하나씩 읽은 영어를 사전 순으로 정렬

		for (int i = M; i <= N; i++) { // M 이상 N 이하의 정수
			int number = i; // 현재 바라보는 정수값
			if (number < 10) { // 10보다 작은 정수라면 한 자리 수이기 때문에 strs에서 바로 매칭
				MyNum myNum = new MyNum(); // MyNum 객체 생성
				myNum.number = number; // 원래 숫자 저장
				myNum.str = strs[number]; // 숫자 단위로 하나씩 읽을 때의 영어 저장
				pq.add(myNum); // 우선순위 큐에 추가
			} else { // 10 이상인 정수라면 두 자리 수이기 때문에 (십의 자리수 + " " + 일의 자리수) == 숫자 단위로 하나씩 읽을 때의 영어이다.
				int first = number / 10; // 십의 자리 수
				int second = number % 10; // 일의 자리 수
				MyNum myNum = new MyNum(); // MyNum 객체 생성
				myNum.number = number; // 원래 숫자 저장
				myNum.str = strs[first] + " " + strs[second]; // 숫자 단위로 하나씩 읽을 때의 영어 저장
				pq.add(myNum); // 우선순위 큐에 추가
			}
		}

		int cnt = 0; // 한 줄에 10개씩 출력하기 위한 int형 변수 생성
		while (!pq.isEmpty()) { // 우선순위 큐가 빌 때까지
			MyNum cur = pq.poll(); // 현재 우선순위 큐가 바라보고 있는 사전 순으로 가장 앞에 있는 원소
			sb.append(cur.number).append(" "); // 해당 원소의 원래 숫자와 공백을 StringBuilder에 append
			cnt++; // 갯수 증가
			if (cnt % 10 == 0)
				sb.append("\n"); // 10개를 출력했다면 "\n" 추가 -> 한 줄에 10개씩 출력하기 위함
		}

		System.out.println(sb.toString()); // StringBuilder를 통해 저장된 결과 출력

	}

}
