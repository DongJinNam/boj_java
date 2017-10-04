
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,l;
		Scanner input = new Scanner(System.in);		
		n = input.nextInt();		
		for (int i = 0; i < n; i++) {
			l = input.nextInt();
			for (int j = 0; j < l; j++) {
				System.out.printf("=");
			}
			System.out.printf("\n");
		}			
	}
}
