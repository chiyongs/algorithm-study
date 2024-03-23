package programmers.정렬.hindex;

import java.util.*;

class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        int end = citations[len-1];

        int max = 1;
        for(int h=0;h<=end;h++) {
            for (int j=0;j<len;j++) {
                if (citations[j] < h) continue;
                if (len-j >= h) {
                    max = h;
                }
            }
        }
        return max;
    }
}
