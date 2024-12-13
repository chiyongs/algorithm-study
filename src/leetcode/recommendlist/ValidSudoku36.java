package leetcode.recommendlist;

import java.util.*;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board)
                && checkCol(board)
                && checkGrid(board);
    }

    boolean checkRow(char[][] board) {
        for (int j = 0; j < 9; j++) {
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    set.add(board[i][j] - '0');
                    cnt++;
                }
            }
            if (cnt != set.size()) {
                return false;
            }
        }
        return true;
    }

    boolean checkCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    set.add(board[i][j] - '0');
                    cnt++;
                }
            }
            if (cnt != set.size()) {
                return false;
            }
        }
        return true;
    }

    boolean checkGrid(char[][] board) {
        return grid(board, 0, 0)
                && grid(board, 0, 3)
                && grid(board, 0, 6)
                && grid(board, 3, 0)
                && grid(board, 3, 3)
                && grid(board, 3, 6)
                && grid(board, 6, 0)
                && grid(board, 6, 3)
                && grid(board, 6, 6);
    }

    boolean grid(char[][] board, int x, int y) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] != '.') {
                    set.add(board[i][j] - '0');
                    cnt++;
                }
            }
        }
        return cnt == set.size();
    }
}
