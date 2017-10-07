import java.util.*;

public class Main {			
	// 9610
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int n,x,y;
		int arr[] = {0,0,0,0,0};	
		n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			x = input.nextInt();
			y = input.nextInt();
			if (x > 0 && y > 0) {
				arr[0]++;
			}
			else if (x < 0 && y > 0) {
				arr[1]++;
			}
			else if (x < 0 && y < 0) {
				arr[2]++;
			}
			else if (x > 0 && y < 0) {
				arr[3]++;
			}
			else {
				arr[4]++;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Q" + (i+1) + ": " + arr[i]);
		}
		System.out.println("AXIS: " + arr[4]);
	}
}
