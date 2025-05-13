package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        fill(map, s1);
        fill(map, s2);
        for (Map.Entry<String, Integer> em : map.entrySet()) {
            if (em.getValue() == 1) {
                ans.add(em.getKey());
            }
        }
        int size = ans.size();
        String[] st = new String[size];
        for (int i = 0; i < size; ++i) {
            st[i] = ans.get(i);
        }
        return st;
    }

    private void fill(Map<String, Integer> map, String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                sb.delete(0, sb.length());
            } else {
                sb.append(s.charAt(i));
            }
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
    }
}
