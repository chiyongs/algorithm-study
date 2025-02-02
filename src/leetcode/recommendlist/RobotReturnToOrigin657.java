package leetcode.recommendlist;

public class RobotReturnToOrigin657 {
    public boolean judgeCircle(String moves) {
        int upCnt = 0;
        int downCnt = 0;
        int leftCnt = 0;
        int rightCnt = 0;
        for (char move : moves.toCharArray()) {
            switch(move) {
                case 'U' -> upCnt++;
                case 'D' -> downCnt++;
                case 'L' -> leftCnt++;
                case 'R' -> rightCnt++;
            }
        }

        return leftCnt == rightCnt && upCnt == downCnt;
    }
}
