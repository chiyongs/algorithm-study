package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        System.out.println(isSameAnagram(anagram(first), anagram(second)) ? "YES" : "NO");
    }

    public static boolean isSameAnagram(Map<Character, Integer> anagram1,
                                         Map<Character, Integer> anagram2) {
        if (anagram1.size() != anagram2.size()) {
            return false;
        }
        for (Character ch : anagram1.keySet()) {
            int num = anagram2.getOrDefault(ch, 101);
            if (num == 101 || anagram1.get(ch) != num) return false;
        }
        return true;
    }

    public static Map<Character, Integer> anagram(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        return map;
    }
}
