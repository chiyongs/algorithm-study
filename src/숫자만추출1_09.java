import java.util.Scanner;

public class 숫자만추출1_09 {
    public int solution(String str) {
        int answer = 0;
        str = str.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(str);
        return answer;
    }

    public static void main(String[] args) {
        숫자만추출1_09 T = new 숫자만추출1_09();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
