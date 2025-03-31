package leetcode.recommendlist;

import java.util.*;

public class FindCommonCharacters1002 {

    public List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();
        int wordsLength = words.length;
        int[][] charArr = new int[wordsLength][26];
        for (int i=0;i<wordsLength;i++) {
            for (char w : words[i].toCharArray()) {
                charArr[i][w-'a']++;
            }
        }

        for (int i=0;i<26;i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0;j<wordsLength;j++) {
                min = Math.min(min, charArr[j][i]);
            }
            for (int k=0;k<min;k++) {
                char ch = (char) ('a' + i);
                commonChars.add(String.valueOf(ch));
            }
        }
        return commonChars;
    }
}
