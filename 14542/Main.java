import java.util.*;

public class Main {			
		
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int l = 1;
		
		while(true) {
			int n;
			int ans = 0;
			int f = 0,s = 0,t = 0;
			
			n = input.nextInt();
			
			if (n == 0) break;
			
			int[][] num_arr = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					num_arr[i][j] = input.nextInt();
					if (i == j) t += num_arr[i][j];
					if (i == n) s += num_arr[i][j];
					if (j == 1) f += num_arr[i][j];
				}								
			}					
			if (n > 1) {
				ans += (t+s+f);
				ans -= (num_arr[1][1] + num_arr[n][1] + num_arr[n][n]);				
			}
			else {
				ans = num_arr[1][1];
			}
			System.out.printf("Case #%d:%d\n", l++, ans);
		}
	}
}
