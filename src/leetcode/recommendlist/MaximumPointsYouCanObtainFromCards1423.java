package leetcode.recommendlist;

public class MaximumPointsYouCanObtainFromCards1423 {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length - k - 1;
        int minSum = 0;
        int totalScore = 0;
        for(int i=0;i<cardPoints.length;i++) {
            totalScore += cardPoints[i];
        }

        for (int i=left;i<=right;i++) {
            minSum += cardPoints[i];
        }

        int sum = minSum;
        while(right < cardPoints.length-1) {
            sum -= cardPoints[left++];
            sum += cardPoints[++right];
            minSum = Math.min(minSum, sum);
        }

        return totalScore-minSum;
    }
}
