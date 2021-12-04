import java.util.Scanner;

public class 암호1_12 {
    public String solution(int n, String str) {
//        String answer = "";
//        str = str.replace("#", "1");
//        str = str.replace("*", "0");
//        int r = 0;
//        for(int i=1; i<=n*7;i++) {
//            if(i%7<7) {
//                r = r*2 + Integer.parseInt(String.valueOf(str.charAt(i-1)));
//                if (i%7==0) {
//                    answer += (char) r;
//                    r = 0;
//                }
//            }
//        }
//        return answer;
        String answer = "";
        for(int i=0; i<str.length();i++) {
            String tmp = str.substring(0,7).replace("#","1").replace("*","0");
            int num = Integer.parseInt(tmp,2);
            answer += (char) num;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        암호1_12 T = new 암호1_12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }
}
