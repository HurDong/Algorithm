package b11052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 1~n개가 들어있는 카드팩 -> 최대 비용
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] cards = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			cards[i] = sc.nextInt();
		}

		// dp[i] : i개의 카드가 필요한 경우 최대 비용
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = cards[i];
			for (int j = 1; j < i; j++) {
				// i-(i+1) ~ i까지 card를 더하며 dp값을 비교
				dp[i] = Math.max(dp[i - j] + cards[j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
