package leetcode.recommendlist;

import java.util.*;

public class UniqueMorseCodeWords804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] args = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<word.length();i++) {
                int idx = word.charAt(i) - 'a';
                sb.append(args[idx]);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
