package leetcode.recommendlist;

public class MaximumNumberOfWordsFoundInSentences2114 {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            String[] splited = sentence.split(" ");
            max = Math.max(max, splited.length);
        }
        return max;
    }
}
