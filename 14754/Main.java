
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int w,h;
		int[][] board;
		int idx, max;
		long ans = 0;
		boolean[][] dp;
		Scanner input = new Scanner(System.in);
		
		h = input.nextInt();
		w = input.nextInt();
		
		board = new int[h][w];
		dp = new boolean[h][w];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				board[i][j] = input.nextInt();				
			}
		}
		
		for (int i = 0; i < h; i++) {
			max = board[i][0];
			idx = 0;
			for (int j = 1; j < w; j++) {
				if (max < board[i][j]) {
					max = board[i][j];
					idx = j;
				}
			}
			dp[i][idx] = true;
		}
		for (int i = 0; i < w; i++) {
			max = board[0][i];
			idx = 0;
			for (int j = 1; j < h; j++) {
				if (max < board[j][i]) {
					max = board[j][i];
					idx = j;
				}
			}
			dp[idx][i] = true;
		}
		
		for (int i = 0; i < h; i++) {			
			for (int j = 0; j < w; j++) {
				if (dp[i][j] == false) {
					ans += board[i][j];
				}
			}
		}
		System.out.println(ans);
	}
}
