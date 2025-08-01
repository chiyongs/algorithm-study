package leetcode.recommendlist;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int minMoves = 0;
        for (int i = 0; i < seats.length; i++) {
            minMoves += Math.abs(seats[i] - students[i]);
        }
        return minMoves;
    }
}
