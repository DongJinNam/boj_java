
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int[] arr = new int[3];
		Scanner input = new Scanner(System.in);
		
		while(true) {			
			for (int i = 0; i < 3; i++) {
				arr[i] = input.nextInt();
			}
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			
			Arrays.sort(arr);			
			if (arr[0] + arr[1] <= arr[2]) {				
				System.out.println("Invalid");
			}
			else if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[0]) {
				System.out.println("Equilateral");
			}
			else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}			
		}		
	}
}
