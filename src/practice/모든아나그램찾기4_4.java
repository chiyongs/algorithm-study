package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램찾기4_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int tLen = T.length();
        for (int i=0;i<tLen;i++) {
            tMap.put(T.charAt(i), tMap.getOrDefault(T.charAt(i), 0) + 1);
        }

        for (int i=0;i<tLen;i++) {
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        int answer = 0;
        if (isSame(tMap, sMap)) answer++;
        int sLen = S.length();
        for (int i=1;i<=sLen - tLen;i++) {
            if (S.charAt(i-1) != S.charAt(i + tLen -1)) {
                sMap.put(S.charAt(i-1), sMap.get(S.charAt(i-1))-1);
                sMap.put(S.charAt(i+tLen-1), sMap.getOrDefault(S.charAt(i+tLen-1), 0)+1);
                if (sMap.get(S.charAt(i-1)) <= 0) {
                    sMap.remove(S.charAt(i - 1));
                }
            }
            if (isSame(tMap, sMap)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isSame(Map<Character, Integer> map1,
                                 Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        for(Character ch : map2.keySet()) {
            int val = map1.getOrDefault(ch, Integer.MAX_VALUE);
            if (val == Integer.MAX_VALUE || val != map2.get(ch)) return false;
        }
        return true;
    }
}
