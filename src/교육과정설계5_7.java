import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계5_7 {
	public String solution(String str, String s) {
		String answer = "NO";
		Queue<Character> nec = new LinkedList<>();
				
		for(int i=0;i<str.length();i++) {
			nec.offer(str.charAt(i));
		}
		
		for(int i=0;i<s.length();i++) {
			if(!nec.isEmpty()) {
				if(s.charAt(i) == nec.peek()) {
					nec.poll();
				}
			}
		}
		
		if(nec.isEmpty()) answer="YES";
		
		return answer;
	}

	
	public static void main(String[] args) {
		교육과정설계5_7 T = new 교육과정설계5_7();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String s = sc.next();
		System.out.println(T.solution(str,s));
	}
}
