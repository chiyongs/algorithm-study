package leetcode.recommendlist;

public class TruncateSentence1816 {
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<k-1;i++) {
            sb.append(str[i]+" ");
        }
        sb.append(str[k-1]);
        return sb.toString();
    }
}
