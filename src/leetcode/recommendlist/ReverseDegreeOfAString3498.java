package leetcode.recommendlist;

public class ReverseDegreeOfAString3498 {
    public int reverseDegree(String s) {
        int revDeg = 0;
        for (int i=0;i<s.length();i++) {
            revDeg += ('z' - s.charAt(i) + 1) * (i+1);
        }
        return revDeg;
    }
}
