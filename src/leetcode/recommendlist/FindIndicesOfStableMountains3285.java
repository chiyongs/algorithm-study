package leetcode.recommendlist;

import java.util.ArrayList;
import java.util.List;

public class FindIndicesOfStableMountains3285 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        int len = height.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<len-1;i++) {
            if (height[i] > threshold) {
                list.add(i+1);
            }
        }
        return list;
    }
}
