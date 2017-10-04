
import java.awt.*;
import java.util.*;

public class Main {
	static int yy[] = {0,0,-1,1};
	static int xx[] = {1,-1,0,0};
	
	static boolean isPossible(int y,int x,int ny,int nx) {
		return y >= 0 && y < ny && x >= 0 && x < nx;
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r,c,max = 0;
		Scanner input = new Scanner(System.in);
		String[] board;
		boolean[][] check;
		boolean bAns = false;

		r = input.nextInt();
		c = input.nextInt();
		board = new String[r];
		check = new boolean[r][c];
		Queue<Point> bfs = new LinkedList<Point>();
		
		input.nextLine();
		for (int i = 0; i < r; i++) {
			board[i] = input.nextLine();
			if (i == 0) {
				for (int j = 0; j < c; j++) {
					char at = board[i].charAt(j);
					if (at == '0') {
						bfs.offer(new Point(j,i));
					}
				}				
			}
		}			
		// bfs	
		while (!bfs.isEmpty()) {
			int x = bfs.peek().x;
			int y = bfs.peek().y;
			bfs.poll(); // pop
			
			if (check[y][x] == true) continue;
			
			check[y][x] = true;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + yy[i];
				int nx = x + xx[i];				
				if (isPossible(ny, nx, r, c) && check[ny][nx] == false) {
					if (board[ny].charAt(nx) == '0') {
						bfs.offer(new Point(nx,ny)); // push
					}
				}
			}
		}
		// answer check
		for (int j = 0; j < c; j++) {
			if (board[r-1].charAt(j) == '0' && check[r-1][j] == true) {
				bAns = true;
				break;
			}
		}		
		if (bAns == true) System.out.println("YES");
		else System.out.println("NO");		
	}
}
