package programmers.카카오.블라인트채용2023.택배배달과수거하기;

import java.util.ArrayList;
import java.util.List;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        long totalDlv = 0L;
        long totalPck = 0L;
        for (int i = 0; i < n; i++) {
            totalDlv += deliveries[i];
            totalPck += pickups[i];
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (totalDlv > 0 || totalPck > 0) {
            int amount = cap;
            long result = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (deliveries[i] > 0 && amount > 0) {
                    if (deliveries[i] > amount) {
                        deliveries[i] -= amount;
                        totalDlv -= amount;
                        amount = 0;
                        break;
                    } else if (deliveries[i] == amount) {
                        deliveries[i] = 0;
                        totalDlv -= amount;
                        amount = 0;
                    } else {
                        amount -= deliveries[i];
                        totalDlv -= deliveries[i];
                        deliveries[i] = 0;
                    }
                    result = Math.max(result, i + 1);
                }
            }

            amount = cap;
            for (int i = n - 1; i >= 0; i--) {
                if (pickups[i] > 0 && amount > 0) {
                    if (pickups[i] > amount) {
                        pickups[i] -= amount;
                        totalPck -= amount;
                        amount = 0;
                        break;
                    } else if (pickups[i] == amount) {
                        totalPck -= amount;
                        pickups[i] = 0;
                        amount = 0;
                    } else {
                        amount -= pickups[i];
                        totalPck -= pickups[i];
                        pickups[i] = 0;
                    }
                    result = Math.max(result, i + 1);
                }
            }
            answer = answer + (result * 2);
        }
        return answer;
    }

    public static void main(String[] args) {
        택배배달과수거하기 s = new 택배배달과수거하기();
        long answer = s.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        long answer2 = s.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(answer);
        System.out.println(answer2);

    }
}
