package leetcode.recommendlist;

public class ScoreOfAString3110 {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i=1;i<s.length();i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);

            score += Math.abs(prev - cur);
        }
        return score;
    }
}
