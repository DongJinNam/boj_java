
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int ans = 1;
		int tmp = 1, tmp2 = 1;
		int max = -100000000;
		int[] arr;
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();				
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		
		Arrays.sort(arr);
			
		tmp = arr[n-1] * arr[n-2];
		tmp2 = arr[0] * arr[1];
		
		ans = tmp > tmp2 ? tmp : tmp2;
		ans = tmp2 * arr[n-1] > ans ? tmp2 * arr[n-1] : ans;
		
		tmp2 = arr[n-1] * arr[n-2] * arr[n-3];
		ans = tmp2 > ans ? tmp2 : ans;
		
		System.out.println(ans);
	}
}
