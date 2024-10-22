package leetcode.recommendlist;

import java.util.*;

public class RepeatedDNASequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int lengthSequence = 10;
        List<String> res = new ArrayList<String>();
        Set<String> resHash = new HashSet<>();
        for (int i = 0; i <= s.length() - lengthSequence; i++) {
            String resStr = s.substring(i, i + lengthSequence);
            boolean isNew = resHash.add(resStr);
            if (!isNew && !res.contains(resStr)) {

                res.add(resStr);
            }
        }
        return res;
    }
}
