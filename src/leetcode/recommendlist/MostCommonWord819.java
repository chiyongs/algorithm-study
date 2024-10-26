package leetcode.recommendlist;

import java.util.*;

public class MostCommonWord819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String e : arr) {
            boolean flag = false;
            for (String ban : banned) {
                if (e.equals(ban)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                map.put(e, map.getOrDefault(e, 0)+1);
            }
        }

        String result = "";
        int max = 0;
        for (String e : map.keySet()) {
            int count = map.get(e);
            if (count > max) {
                result = e;
                max = count;
            }
        }
        return result;
    }
}
