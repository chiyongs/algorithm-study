package practice;

import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬6_7 {

    static class Coord implements Comparable<Coord> {
        int x, y;

        Coord(int x, int y) {
            this.x=x;
            this.y=y;
        }


        @Override
        public int compareTo(Coord o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Coord[] coords = new Coord[n];
        for(int i=0;i<n;i++) {
            coords[i] = new Coord(in.nextInt(), in.nextInt());
        }

        Arrays.sort(coords);
        for(int i=0;i<n;i++) {
            System.out.println(coords[i].x + " " + coords[i].y);
        }
    }
}
