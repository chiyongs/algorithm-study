package leetcode.recommendlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestCompletingWord748 {

    public static void main(String[] args) {
        ShortestCompletingWord748 s = new ShortestCompletingWord748();
        s.shortestCompletingWord("GrC8950", List.of("measure","other","every","base","according","level","meeting","none","marriage","rest").toArray(new String[4]));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.replaceAll("[0-9\\s]", "").toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : licensePlate.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        String result = "";
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            Map<Character, Integer> chMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                chMap.put(ch, chMap.getOrDefault(ch, 0)+1);
            }

            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char key = entry.getKey();
                int cnt = chMap.getOrDefault(key, -1);
                if (cnt < entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (word.length() < minLen) {
                    result = word;
                    minLen = result.length();
                }
            }
        }
        return result;
    }
}
