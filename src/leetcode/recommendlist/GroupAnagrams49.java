package leetcode.recommendlist;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);

            String sortedStr = new String(chArr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<String> candidates = new ArrayList<>();
    //     Map<String, List<String>> map = new HashMap<>();

    //     int strsLen = strs.length;
    //     for(int i=0;i<strsLen;i++) {
    //         String str = strs[i];
    //         if (candidates.size() < 1) {
    //             candidates.add(str);
    //             List<String> list = new ArrayList<>();
    //             list.add(str);
    //             map.put(str, list);
    //         } else {
    //             boolean result = false;
    //             for(String candidate : candidates) {
    //                 result = isAnagram(candidate, str);
    //                 if (result) {
    //                     List<String> list = map.getOrDefault(candidate, new ArrayList<String>());
    //                     list.add(str);
    //                     map.put(candidate, list);
    //                     break;
    //                 }
    //             }
    //             if (!result) {
    //                 candidates.add(str);
    //                 List<String> temp = new ArrayList<>();
    //                 temp.add(str);
    //                 map.put(str, temp);
    //             }
    //         }
    //     }

    //     return new ArrayList<>(map.values());
    // }

    // boolean isAnagram(String s, String t) {
    //     int[] arr = new int[26];
    //     int slen = s.length();
    //     int tlen = t.length();
    //     for(int i=0;i<slen;i++) {
    //         arr[s.charAt(i)-'a']++;
    //     }
    //     for(int i=0;i<tlen;i++) {
    //         char ch = t.charAt(i);
    //         if (arr[ch-'a'] > 0) {
    //             arr[ch-'a']--;
    //         } else {
    //             return false;
    //         }
    //     }
    //     for(int i=0;i<26;i++) {
    //         if (arr[i] > 0) return false;
    //     }
    //     return true;
    // }
}
