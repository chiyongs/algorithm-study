package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 장난꾸러기6_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] origin = new int[n];
        for(int i=0;i<n;i++) {
            int num = in.nextInt();
            arr[i] = num;
            origin[i] = num;
        }
        Arrays.sort(arr);

        int idx = 0;
        int[] result = new int[2];
        for(int i=0;i<n;i++) {
            if (arr[i] != origin[i]) {
                result[idx++] = i+1;
            }
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }
}
