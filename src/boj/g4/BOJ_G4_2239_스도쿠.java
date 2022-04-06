package boj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyongs
 * @since 2022. 4. 6.
 * @see https://www.acmicpc.net/problem/2239
 * @performance 16392	564
 * @category #백트래킹 #구현
 * @note
 */
public class BOJ_G4_2239_스도쿠 {
	
	static class Point {
		int r,c;
		
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	
	}
	
	static List<Point> list;
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		flag = false;
		list = new ArrayList<>();
		for(int i=0;i<9;i++) {
			String input = br.readLine();
			for(int j=0;j<9;j++) {
				int num = input.charAt(j) - '0';
				if(num == 0) {
					list.add(new Point(i,j));
				}
				map[i][j] = num;
			}
		}
		
		sudoku(0);
		
	}
	
	private static void sudoku(int cnt) {
		if(flag) {
			return;
		}
		if(cnt == list.size()) {
			flag = true;
            StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());			
			return;
		}
		
		Point cur = list.get(cnt);
		for(int i=1;i<10;i++) {
			if(checkRow(cur.r, i) && checkCol(cur.c, i) &&
					check3By3(cur.r,cur.c,i)) {
				select(cur, i);
				sudoku(cnt+1);
				select(cur, 0);			
			}
		}
	}
	
	private static boolean check3By3(int r, int c, int num) {
		if(r>=0 && r<3 && c>=0 && c<3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=0 && r<3 && c>=3 && c<6) {
			for(int i=0;i<3;i++) {
				for(int j=3;j<6;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=0 && r<3 && c>=6 && c<9) {
			for(int i=0;i<3;i++) {
				for(int j=6;j<9;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=3 && r<6 && c>=0 && c<3) {
			for(int i=3;i<6;i++) {
				for(int j=0;j<3;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=3 && r<6 && c>=3 && c<6) {
			for(int i=3;i<6;i++) {
				for(int j=3;j<6;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=3 && r<6 && c>=6 && c<9) {
			for(int i=3;i<6;i++) {
				for(int j=6;j<9;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=6 && r<9 && c>=0 && c<3) {
			for(int i=6;i<9;i++) {
				for(int j=0;j<3;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=6 && r<9 && c>=3 && c<6) {
			for(int i=6;i<9;i++) {
				for(int j=3;j<6;j++) {
					if(map[i][j] == num) return false;
				}
			}
		} else if(r>=6 && r<9 && c>=6 && c<9) {
			for(int i=6;i<9;i++) {
				for(int j=6;j<9;j++) {
					if(map[i][j] == num) return false;
				}
			}
		}		
		return true;
	}
	
	private static boolean checkRow(int r, int num) {
		for(int c=0;c<9;c++) {
			if(map[r][c] == num) return false;
		}
		return true;
	}
	
	private static boolean checkCol(int c, int num) {
		for(int r=0;r<9;r++) {
			if(map[r][c] == num) return false;
		}
		return true;
	}
	
	private static void select(Point p, int num) {
		map[p.r][p.c]= num; 
	}
	
}
