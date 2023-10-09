

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] square = new int[100][100];
		int n = sc.nextInt();
		int size = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (square[j][k] == 1)
						size++;
					else {
						square[j][k] = 1;
					}
				}
			}
		}

		System.out.println((n * 100) - size);
	}
}
