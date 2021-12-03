import java.util.Scanner;

public class 중복문자제거1_06 {
    public String solution(String str) {
        String answer="";
        char[] c = str.toCharArray();
        int[] n = new int[26];
        for (int i=0;i<str.length();i++) {
            if (n[c[i] - 97] ==1) {
                continue;
            } else {
                n[c[i] - 97] = 1;
                answer += c[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        중복문자제거1_06 T = new 중복문자제거1_06();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
