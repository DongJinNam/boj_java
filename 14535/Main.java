
import java.awt.*;
import java.util.*;
import java.math.*;

public class Main {			
	
	static String monthstr[];
	
	static void print(int month, int n) {
		System.out.printf(monthstr[month] + ":");
		for (int i = 0; i < n; i++)
			System.out.printf("*");			
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int l = 1;
		monthstr = new String[12];
		monthstr[0] = "Jan";
		monthstr[1] = "Feb";
		monthstr[2] = "Mar";
		monthstr[3] = "Apr";
		monthstr[4] = "May";
		monthstr[5] = "Jun";
		monthstr[6] = "Jul";
		monthstr[7] = "Aug";
		monthstr[8] = "Sep";
		monthstr[9] = "Oct";
		monthstr[10] = "Nov";
		monthstr[11] = "Dec";
		
		while(true) {
		
			int n = input.nextInt();
			int arr[] = new int[12];						
			if (n == 0) break;
			
			for (int i = 0; i < n; i++) {
				int d,m,y;
				d = input.nextInt();
				m = input.nextInt();
				y = input.nextInt();
				arr[m-1]++;
			}
			
			System.out.printf("Case #%d:\n",l++);
			for (int i = 0; i < 12; i++) {
				print(i,arr[i]);
			}
		}				
	}
}
