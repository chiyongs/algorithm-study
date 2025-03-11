package leetcode.recommendlist;

public class GoatLatin924 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (vowels.indexOf(word.charAt(0)) != -1) {
                word += "ma";
            } else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            word += "a".repeat(i + 1);

            res.append(word).append(" ");
        }
        return res.toString().trim();
    }
}
