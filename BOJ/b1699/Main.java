package b1699;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[n + 1]; // dp[i] : 정수 i의 제곱수들의 합 최소개수

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			// i 수에서 제곱수를 뺀게 현재 dp값보다 작으면 그값으로 바꿈
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
