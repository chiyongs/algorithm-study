package boj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_S4_20436_ZOAC {

    static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l','.'}, {'z', 'x', 'c', 'v', 'b', 'n', 'm','.','.','.'}};

    static List<Character> leftHand = List.of('q','w','e','r','t','a','s','d','f','g','z','x','c','v');
    static List<Character> rightHand = List.of('y','u','i','o','p','h','j','k','l','b','n','m');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char startL = st.nextToken().charAt(0);
        char startR = st.nextToken().charAt(0);

        String input = br.readLine();
        int time = 0;
        for(int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if (leftHand.contains(ch)) {
                time += getDistance(startL, ch);
                time++;
                startL = ch;
            } else {
                time += getDistance(startR, ch);
                time++;
                startR = ch;
            }
        }
        System.out.println(time);
    }

    static int getDistance(char from, char to) {
        if (from == to) return 0;
        int fromX = 0, fromY = 0, toX = 0, toY =0;
        for(int i=0;i<3;i++) {
            for(int j=0;j<10;j++) {
                if (keyboard[i][j] == from) {
                    fromX = i;
                    fromY = j;
                } else if (keyboard[i][j] == to) {
                    toX = i;
                    toY = j;
                }
            }
        }
        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}
