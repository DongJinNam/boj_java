
import java.util.*;

public class Main {
	static int yy[] = {0,0,-1,1,0,0};
	static int xx[] = {1,-1,0,0,0,0};
	static int zz[] = {0,0,0,0,1,-1};
	
	static class Dim3 {
		int x,y,z;
		public Dim3(int _x,int _y,int _z) {
			x = _x;
			y = _y;
			z = _z;
		}
	}
	
	static boolean isPossible(int x,int y,int z,int c,int r,int h) {
		return x >= 0 && x < c && y >= 0 && y < r && z >= 0 && z < h;
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r,c,h;
		int t_cnt = 0;

		Scanner input = new Scanner(System.in);
		int[][][] board;
		int[][][] dp;
		int max = 0;
		boolean[][][] check;
		
		c = input.nextInt();
		r = input.nextInt();
		h = input.nextInt();
		
		board = new int[h][r][c];
		dp = new int[h][r][c];
		check = new boolean[h][r][c];
		
		Queue <Dim3> bfs = new LinkedList<Dim3>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {			
				for (int k = 0; k < c; k++) {
					board[i][j][k] = input.nextInt();
					dp[i][j][k] = 1000001;
					if (board[i][j][k] >= 0) t_cnt++;
					if (board[i][j][k] == 1) {
						bfs.offer(new Dim3(k,j,i));
						dp[i][j][k] = 0;
					}					
				}
			}			
		}
		
		while(!bfs.isEmpty()) {
			Dim3 top = bfs.peek();
			int z = top.z;
			int y = top.y;
			int x = top.x;
			bfs.poll();
			
			if (check[z][y][x] == true) continue;
			
			check[z][y][x] = true;			
			t_cnt--;
			
			for (int i = 0; i < 6; i++) {
				int nz = z + zz[i];
				int ny = y + yy[i];
				int nx = x + xx[i];								
				
				if (isPossible(nx, ny, nz, c, r, h) && check[nz][ny][nx] == false && board[nz][ny][nx] >= 0) {
					bfs.offer(new Dim3(nx,ny,nz));
					if (dp[nz][ny][nx] > dp[z][y][x] + 1) { 
						dp[nz][ny][nx] = dp[z][y][x] + 1;
						max = dp[nz][ny][nx] > max ? dp[nz][ny][nx] : max; 
					}
				}
			}
		}		
		if (t_cnt != 0) System.out.println(-1);
		else System.out.println(max);
	}
}
