package leetcode.recommendlist;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] alphabetCnt = new int[26];
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) return false;
        for(int i=0;i<sLen;i++) {
            alphabetCnt[s.charAt(i)-'a']++;
        }

        for(int i=0;i<tLen;i++) {
            char ch = t.charAt(i);
            if (alphabetCnt[ch-'a'] <= 0) {
                return false;
            } else {
                alphabetCnt[ch-'a']--;
            }
        }

        for(int i=0;i<26;i++) {
            if (alphabetCnt[i] > 0) return false;
        }
        return true;
    }

    // public boolean isAnagram(String s, String t) {
    //     Map<Character,Integer> map = new HashMap<>();
    //     int sLen = s.length();
    //     for(int i=0;i<sLen;i++) {
    //         char ch = s.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0)+1);
    //     }

    //     int tLen = t.length();
    //     for(int i=0;i<tLen;i++) {
    //         char tCh = t.charAt(i);
    //         if (!map.containsKey(tCh)) {
    //             return false;
    //         } else {
    //             int cnt = map.get(tCh);
    //             if (cnt <= 1) {
    //                 map.remove(tCh);
    //             } else {
    //                 map.put(tCh, cnt-1);
    //             }
    //         }
    //     }
    //     return map.size() > 0 ? false : true;
    // }
}
