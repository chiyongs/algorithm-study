import java.util.ArrayList;
import java.util.Scanner;

public class 큰수출력하기2_01 {
    public ArrayList<Integer> solution(int n, int[] num) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<n-1; i++) {
            if (i==0) answer.add(num[0]);
            if(num[i+1]>num[i]) answer.add(num[i+1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        큰수출력하기2_01 T = new 큰수출력하기2_01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n;i++) {
            num[i] = kb.nextInt();
        }
        for(int x : T.solution(n, num)) {
            System.out.print(x + " ");
        }
    }
}
