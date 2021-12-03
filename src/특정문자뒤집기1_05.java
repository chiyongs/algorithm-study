import java.util.Scanner;

public class 특정문자뒤집기1_05 {
    public String solution(String str) {
        String answer="";
        int lt=0,rt=str.length()-1;
        char[] c = str.toCharArray();
        char[] s = new char[str.length()];
        int j = 0;
        for (int i =str.length()-1; i>=0; i--) {
            if (Character.isAlphabetic(c[i])) s[j++]=c[i];
        }
        j=0;
        for (int i =0 ; i<str.length(); i++) {
            if (Character.isAlphabetic(c[i])) {
                c[i] =s[j++];
            }
        }
        answer = String.valueOf(c);
        return answer;
    }

    public static void main(String[] args) {
        특정문자뒤집기1_05 T = new 특정문자뒤집기1_05();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
