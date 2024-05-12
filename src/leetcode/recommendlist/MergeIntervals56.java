package leetcode.recommendlist;

import java.util.*;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i,j) -> i[0] - j[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int i=1;i<intervals.length;i++) {
            if (end >= intervals[i][0]) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][2]);
    }
}
