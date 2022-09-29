package programmers.lv3.힙;

import java.util.*;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        int max = 0;
        int min = 0;
        for(String operation : operations) {
            String[] str = operation.split(" ");
            int num = Integer.parseInt(str[1]);
            if(str[0].equals("I")) {
                tmap.put(num, tmap.getOrDefault(num, 0)+1);
            } else {
                if(tmap.isEmpty()) continue;
                if(num == 1) {
                    max = tmap.lastKey();
                    int result = tmap.get(max);
                    if(result == 0) continue;
                    else if(result == 1) {
                        tmap.remove(max);
                    }
                    else tmap.put(max, result-1);
                } else {
                    min = tmap.firstKey();
                    int result = tmap.get(min);
                    if(result == 0) continue;
                    else if(result == 1) {
                        tmap.remove(min);
                    }
                    else tmap.put(min, result-1);
                }
            }
        }

        if(tmap.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = tmap.lastKey();
            answer[1] = tmap.firstKey();
        }

        return answer;
    }
}
