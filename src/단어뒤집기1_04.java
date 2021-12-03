import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기1_04 {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
//        for (String s : str) {
//            StringBuilder sb = new StringBuilder(s);
//            answer.add(sb.reverse().toString());
//        }
        for (String x : str) {
            char[] c = x.toCharArray();
            int lt=0,rt=x.length()-1;
            while(lt<rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(c.toString());
            String s = String.valueOf(c);
            answer.add(s);
        }
        return answer;
    }

    public static void main(String[] args) {
        단어뒤집기1_04 T = new 단어뒤집기1_04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0 ; i<n; i++) {
            str[i] = kb.next();
        }
        for (String x : T.solution(n,str)) {
            System.out.println(x);
        }
    }
}
