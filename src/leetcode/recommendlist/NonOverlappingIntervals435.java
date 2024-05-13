package leetcode.recommendlist;

import java.util.*;

public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i,j) -> {
            if (i[0] == j[0]) return i[1] - j[1];
            return i[0] - j[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        int result = 0;
        for(int i=1;i<intervals.length;i++) {
            if (end > intervals[i][0]) {
                result++;

                end = Math.min(end, intervals[i][1]);
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return result;
    }
}
