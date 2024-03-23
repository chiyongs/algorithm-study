package programmers.카카오.블라인드채용2022.k진수에서소수개수구하기;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String target = createJinsu(n, k);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<target.length();i++) {
            char ch = target.charAt(i);
            if (ch == '0') {
                if (sb.length() == 0) continue;
                if (isPrime(Long.parseLong(sb.toString())))
                    answer++;

                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() != 0) {
            if (isPrime(Long.parseLong(sb.toString()))) answer++;
        }
        return answer;
    }

    public String createJinsu(int n, int k) {
        int temp = n;
        StringBuilder sb = new StringBuilder();
        while(temp > 0) {
            int res = temp % k;
            temp /= k;
            sb.append(res);
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;

        long num = (long) Math.sqrt(n);
        for (long i=2;i<=num;i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}