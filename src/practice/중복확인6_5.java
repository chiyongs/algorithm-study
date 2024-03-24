package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 중복확인6_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++) {
            int num = in.nextInt();
            if (set.contains(num)) {
                System.out.println("D");
                return;
            }
            set.add(num);
        }
        System.out.println("U");
    }
}
