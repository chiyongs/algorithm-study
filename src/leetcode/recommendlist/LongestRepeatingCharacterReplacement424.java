package leetcode.recommendlist;

public class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int max = 0;
        int start = 0;
        int result = 0;
        for(int end = 0; end < s.length(); end++) {
            arr[s.charAt(end)-'A']++;
            max = Math.max(max, arr[s.charAt(end)-'A']);
            if (end - start + 1 - max > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
