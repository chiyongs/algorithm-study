package programmers;

public class 문제124나라의숫자 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n / 3 >= 0 && n != 0) {
            int res = n % 3;
            if (res == 0) {
                n = n/3 -1;
                answer.insert(0, "4");
            } else if (res == 1) {
                n /= 3;
                answer.insert(0, "1");
            } else {
                n /= 3;
                answer.insert(0, "2");
            }

        }

        return answer.toString();
    }
}
