package b15988;

import java.util.Scanner;

public class Main {
	final static int INF = 1000001;
	final static int DIV = 1000000009;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		int[] dp = new int[INF]; // dp[i] : 정수 i를 1과 2와 3들의 합으로 만드는 경우의 수

		dp[1] = 1; // 1
		dp[2] = 2; // 1+1 2
		dp[3] = 4; // 1+1+1 1+2 2+1 3

		// dp[4] : 1+1+1+1 1+1+2 1+2+1 2+1+1 1+3 3+1 2+2

		for (int i = 4; i < INF; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2]) % DIV + dp[i - 3]) % DIV;
		}
		while (T-- > 0) {
			int n = sc.nextInt();
			sb.append(dp[n] + "\n");
		}
		System.out.println(sb.toString());
	}
}
