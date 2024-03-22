package practice;

import java.util.*;

public class 학급회장4_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int result = map.getOrDefault(c, 0);
            map.put(c, result + 1);
        }

        int max = 0;
        char maxCh = 'a';
        for (Character ch : map.keySet()) {
            if (max < map.get(ch)) {
                max = map.get(ch);
                maxCh = ch;
            }
        }
        System.out.print(maxCh);
    }
}
