
import java.awt.Point;
import java.util.*;

public class Main {
	static int yy[] = {0,0,-1,1};
	static int xx[] = {1,-1,0,0};
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r,c;
		int s_c = 0, w_c = 0;

		Scanner input = new Scanner(System.in);
		String[] board;
		boolean[][] check;
		
		r = input.nextInt();
		c = input.nextInt();
		
		board = new String[r];
		check = new boolean[r][c];
		
		input.nextLine();
		for (int i = 0; i < r; i++) {
			board[i] = input.nextLine();
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {				
				int a = 0, b = 0;				
				if (check[i][j] == false) {
					
					// using bfs
					Queue<Point> bfs = new LinkedList<Point>();					
					bfs.offer(new Point(j,i));					
					while (!bfs.isEmpty()) {
						int y = bfs.peek().y;
						int x = bfs.peek().x;
						bfs.poll();
						
						if (check[y][x] == true) continue;
						
						check[y][x] = true;
						if (board[y].charAt(x) == 'o') a++;
						if (board[y].charAt(x) == 'v') b++;
						
						for (int k = 0; k < 4; k++) {
							int ny = y + yy[k];
							int nx = x + xx[k];
							
							if (ny >= 0 && ny < r && nx >= 0 && nx < c && check[ny][nx] == false && board[ny].charAt(nx) != '#') {								
								
								bfs.offer(new Point(nx,ny));
							}							
						}						
					}
					if (a > b) s_c += a;
					else w_c += b;
				}								
			}
		}
		
		System.out.println(s_c + " " + w_c);				
	}
}
