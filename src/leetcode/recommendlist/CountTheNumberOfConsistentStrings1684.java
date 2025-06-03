package leetcode.recommendlist;

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int count = 0;
        int i=0;
        int j=0;
        for(i=0;i<words.length;i++){
            String str = words[i];
            for(j=0;j<str.length();j++){
                if(!set.contains(str.charAt(j))){
                    break;
                }
            }
            if(j==str.length()){
                count++;
            }
        }
        return count;
    }
}
