package programmers;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int len = a.length;
        for (int i=0;i<len;i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
