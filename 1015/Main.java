
import java.awt.*;
import java.util.*;
import java.math.*;

public class Main {			
	
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		
		int n;
		int[] pi;
		int[] num_arr;
		int count = 0;
		boolean[] check;
		n = input.nextInt();
		
		pi = new int[n];
		num_arr = new int[n];
		check = new boolean[1001];
		
		for (int i = 0; i < n; i++) {
			num_arr[i] = input.nextInt();
			check[num_arr[i]] = true;
		}
		
		for (int i = 0; i <= 1000; i++) {
			if (check[i] == true) {
				for (int j = 0; j < n; j++) {
					if (num_arr[j] == i) {
						pi[j] = count;
						count++;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ",pi[i]);
		}
				
	}
}
