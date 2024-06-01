package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : a) {
            map.put(e, map.getOrDefault(e,0)+1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }
        return 0;
    }
}
