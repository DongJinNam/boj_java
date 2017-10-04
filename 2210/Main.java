
import java.awt.*;
import java.util.*;
import java.math.*;

public class Main {			
	
	static boolean[] check;
	static int[][] board;
	static int yy[] = {0,0,-1,1};
	static int xx[] = {1,-1,0,0};
	static int count = 0;
	// is possible area?
	static boolean isPossible(int y,int x,int ny,int nx) {
		return y >= 0 && y < ny && x >= 0 && x < nx;
	}
	// recursion function
	static void go(int y,int x, int n,int total) {
		if (n == 0) {
			total += board[y][x];
			if (check[total] == false) {
				check[total] = true;
				count++;
			}
			return;
		}
		else {
			total += Math.pow(10, n) * board[y][x];
			for (int i = 0; i < 4; i++) {
				int ny = y + yy[i];
				int nx = x + xx[i];
				if (isPossible(ny,nx,5,5)) go(ny,nx,n-1,total);
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);		
		board = new int[5][5];
		check = new boolean[1000001];				
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = input.nextInt();	
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				go(i,j,5,0);	
			}
		}				
		System.out.println(count);
	}
}
