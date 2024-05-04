package programmers;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int n = nums.length;
        int mapSize = map.size();
        if (mapSize > n/2) {
            mapSize = n/2;
        }
        return mapSize;
    }
}
