

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int amount = sc.nextInt();
		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();

		}

		int idx = 0;
		int count=0;
		
		while (true) {
			for (int i = n - 1; i >= 0; i--) {
				if (coin[i] <= amount) {
					idx = i;
					break;
				}
			}
			amount = amount - coin[idx];
			count++;
			if(amount==0) break;
		}
		System.out.println(count);

	}
}
