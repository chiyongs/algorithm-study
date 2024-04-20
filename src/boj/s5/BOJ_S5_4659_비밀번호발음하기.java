package boj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_4659_비밀번호발음하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals("end")) {
            boolean flag = containAeiou(str) && !checkContinous(str) && !checkDuplicate(str);
            sb.append("<").append(str).append("> is ");
            if (flag) {
                sb.append("acceptable.");
            } else {
                sb.append("not acceptable.");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static boolean containAeiou(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a'
                || str.charAt(i) == 'e'
                || str.charAt(i) == 'i'
                || str.charAt(i) == 'o'
                || str.charAt(i) == 'u') {
                return true;
            }
        }
        return false;
    }

    static boolean checkDuplicate(String str) {
        for(int i=0;i<str.length()-1;i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                if (str.charAt(i) != 'e' && str.charAt(i) != 'o') {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkContinous(String str) {
        int moCnt = 0;
        int jaCnt = 0;
        for(int i=0;i<str.length();i++) {
            if (isMo(str.charAt(i))) {
                moCnt++;
                jaCnt = 0;
            }
            else {
                jaCnt++;
                moCnt = 0;
            }

            if (moCnt == 3 || jaCnt == 3) return true;
        }

        return false;
    }

    static boolean isMo(char ch) {
        char[] mo = {'a','e','i','o','u'};
        for(char m : mo) {
            if (m == ch) return true;
        }
        return false;
    }
}
