package b2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 전체 100 색종이 10
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] papers = new int[n][2];

		for (int i = 0; i < n; i++) {
			papers[i][0] = sc.nextInt();
			papers[i][1] = sc.nextInt();
		}
		
		// 10+2+10+5+10+10+2+8+7+10
		
	}
}
