import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer="";
        StringBuilder s = new StringBuilder(str.toLowerCase()).reverse();
        if (s.toString().equals(str.toLowerCase())) {
            answer = "YES";
        } else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
