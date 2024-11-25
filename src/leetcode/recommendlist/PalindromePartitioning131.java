package leetcode.recommendlist;

import java.util.*;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        getSubstrings(s, new ArrayList<>(), result);
        return result;
    }

    void getSubstrings(String s, List<String> step, List<List<String>> result) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for (int i=1;i<=s.length();i++) {
            String substr = s.substring(0, i);
            if (!isPalindrome(substr)) continue;

            step.add(substr);
            getSubstrings(s.substring(i, s.length()), step, result);
            step.remove(step.size()-1);
        }
        return;
    }

    boolean isPalindrome(String s) {
        int first = 0;
        int last = s.length() - 1;

        while (first <= last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            } else {
                first++;
                last--;
            }
        }
        return true;
    }
}
