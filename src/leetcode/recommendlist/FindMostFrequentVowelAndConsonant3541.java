package leetcode.recommendlist;

import java.util.List;

public class FindMostFrequentVowelAndConsonant3541 {
    static List<Character> vowels = List.of('a', 'e','i','o','u');

    public int maxFreqSum(String s) {
        int[] cnts = new int[26];

        for (char ch : s.toCharArray()) {
            cnts[ch-'a']++;
        }

        int vowelFreq = 0;
        int consFreq = 0;
        for (int i=0;i<cnts.length;i++) {
            if (vowels.contains((char)('a'+i))) {
                vowelFreq = Math.max(vowelFreq, cnts[i]);
            } else {
                consFreq = Math.max(consFreq, cnts[i]);
            }
        }

        return vowelFreq + consFreq;
    }
}
