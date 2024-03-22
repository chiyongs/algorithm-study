package practice;

import java.util.*;

public class 매출액의종류4_3 {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        list.add(map.size());
        for (int i = 1; i < N - K + 1; i++) {
            if (arr[i-1] == arr[i + K - 1]) {
                list.add(map.size());
            } else {
                int val = map.get(arr[i-1]);
                if (val <= 1) {
                    map.remove(arr[i-1]);
                } else {
                    map.put(arr[i-1], val - 1);
                }

                map.put(arr[i+K-1], map.getOrDefault(arr[i+K-1], 0)+1);
                list.add(map.size());
            }
        }

        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }
}
