package practice;

import java.util.Scanner;

public class 선택정렬6_1 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
