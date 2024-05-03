package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String comp : completion) {
            map.put(comp, map.getOrDefault(comp, 0)+1);
        }
        for(String part : participant) {
            int cnt = map.getOrDefault(part, 0);

            if (cnt == 0) return part;
            else {
                map.put(part, cnt-1);
            }
        }
        return "";
    }
}
