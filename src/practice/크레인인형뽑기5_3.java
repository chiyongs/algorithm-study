package practice;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기5_3 {
	public int solution(int[][] board, int[] moves,int n, int m) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		for(int x : moves) {
			for(int r = 0; r<n;r++) {
				if(board[r][x]!=0) {
					if(stack.isEmpty()) {
						stack.push(board[r][x]);
					} else {						
						if(stack.get(stack.size()-1) == board[r][x]) {							
							stack.pop();
							answer+= 2;
						} else {
							stack.push(board[r][x]);
						}
					}
					board[r][x] = 0;
					break;
				}
			}
		}
		return answer;
	}

	
	public static void main(String[] args) {
		크레인인형뽑기5_3 T = new 크레인인형뽑기5_3();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n+1];
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int m = sc.nextInt();
		int[] moves = new int[m];
		for(int i=0;i<m;i++) {
			moves[i] = sc.nextInt();
		}
		
		System.out.println(T.solution(board, moves,n,m));

		
	}
}
