package programmers;

import java.util.List;

public class 키패드누르기 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static List<Integer> leftHandNumber = List.of(1,4,7);
    static List<Integer> rightHandNumber = List.of(3,6,9);
    static int[][] pads = {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int curLeft = 10;
        int curRight = 11;
        for(int number : numbers) {
            if (leftHandNumber.contains(number)) {
                curLeft = number;
                answer.append("L");
            } else if (rightHandNumber.contains(number)) {
                curRight = number;
                answer.append("R");
            } else {
                int leftDistance = getDistance(curLeft, number);
                int rightDistance = getDistance(curRight, number);

                if (leftDistance < rightDistance) {
                    curLeft = number;
                    answer.append("L");
                } else if (leftDistance > rightDistance) {
                    curRight = number;
                    answer.append("R");
                } else {
                    if ("left".equals(hand)) {
                        curLeft = number;
                        answer.append("L");
                    } else {
                        curRight = number;
                        answer.append("R");
                    }
                }
            }
        }

        return answer.toString();
    }

    public int getDistance(int cur, int number) {
        if (cur == number) return 0;
        int curX = 0, curY = 0;
        int numberX = 0, numberY = 0;

        for(int i=0;i<pads.length;i++) {
            for(int j=0;j<pads[0].length;j++) {
                if (pads[i][j] == cur) {
                    curX = i;
                    curY = j;
                } else if (pads[i][j] == number) {
                    numberX = i;
                    numberY = j;
                }
            }
        }

        return Math.abs(curX - numberX) + Math.abs(curY - numberY);
    }
}
