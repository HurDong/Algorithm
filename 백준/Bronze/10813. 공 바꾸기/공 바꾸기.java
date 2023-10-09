

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] basket = new int[n];
		for(int i=0;i<n;i++)
		{
			basket[i] = i+1;
		}
		
		int first =0;
		int last =0;
		for (int i = 0; i < m; i++) {
			first = sc.nextInt() -1 ;
			last = sc.nextInt() - 1;
			int temp = basket[first];
			basket[first] = basket[last];
			basket[last] = temp;
		}
		for (int i = 0; i < basket.length; i++) {
			System.out.print(basket[i] + " ");			
		}
	}
}
