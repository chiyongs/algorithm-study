package leetcode.recommendlist;

public class GameOfLife289 {
    static int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    static int row, col;

    public void gameOfLife(int[][] board) {
        row = board.length;
        col = board[0].length;
        int[][] temp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveNeighborCnt = getLiveNeighborCnt(i,j, board);
                if (board[i][j] == 0) {
                    if (liveNeighborCnt == 3) {
                        temp[i][j] = 1;
                    }
                } else {
                    if (liveNeighborCnt < 2) {
                        temp[i][j] = 0;
                    } else if (liveNeighborCnt <= 3) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    int getLiveNeighborCnt(int x, int y, int[][] board) {
        int liveNeighborCnt = 0;
        for (int d = 0; d < 8; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (0 <= dx && dx < row && 0 <= dy && dy < col) {
                if (board[dx][dy] == 1) {
                    liveNeighborCnt++;
                }
            }
        }
        return liveNeighborCnt;
    }
}
