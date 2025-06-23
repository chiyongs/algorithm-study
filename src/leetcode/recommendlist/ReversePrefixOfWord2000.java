package leetcode.recommendlist;

public class ReversePrefixOfWord2000 {
    public String reversePrefix(String word, char ch) {
        int first = word.indexOf(ch);
        if (first == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word.substring(0, first + 1)).reverse();
        sb.append(word.substring(first + 1));
        return sb.toString();
    }
}
