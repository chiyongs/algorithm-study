package leetcode.recommendlist;

import java.util.*;

public class BuddyStrings859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char ch : s.toCharArray()) {
                set.add(ch);
            }
            return set.size() < s.length();
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<s.length();i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    list.add(i);
                }
            }
            return list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1)) && goal.charAt(list.get(0)) == s.charAt(list.get(1));
        }
    }
}
