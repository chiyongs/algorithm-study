package practice;

import java.util.Scanner;

public class 삽입정렬6_3 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }

        for(int i=1;i<n;i++) {
            int temp = arr[i], j;
            for(j=i-1;j>=0;j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else break;
            }
            arr[j+1] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
