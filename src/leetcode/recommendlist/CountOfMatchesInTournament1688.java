package leetcode.recommendlist;

public class CountOfMatchesInTournament1688 {
    public int numberOfMatches(int n) {
        int sum = 0;
        while (n > 1) {
            int matches = n/2;
            sum += matches;
            n -= matches;
        }
        return sum;
    }
}
