package b20500;

import java.util.Scanner;

public class Main {
	final static int DIV = 1000000007;

	public static void main(String[] args) {
		// 1과 5로만 구성된 수
		Scanner sc = new Scanner(System.in);

		// 자리 수
		int n = sc.nextInt();

		// dp[i][j] : 1,5로 만들 수 있느 i자리수 중 3으로 나눴을 때 나머지가 j인 수들
		// 3으로 나눴을때 -> 각 자리수를 다 더해서 3으로 나눔
		int[][] dp = new int[n + 1][3];

		dp[1][1] = 0; // 1 -> X
		dp[1][2] = 1; // 5
		// 마지막 수를 5로 고정시켜 5의 배수를 만족시키자 -> 각 자리수의 합이 3의 배수이기만 하면 15의 배수 성립
		for (int i = 2; i <= n; i++) {
			// 나머지가 0일려면 i-1의 나머지가 1(5를 더해줌) 이거나 2(1를더해줌) 이여야함.
			dp[i][0] = (dp[i - 1][2] + dp[i - 1][1]) % DIV;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
		}

		// dp[n][0] 만이 3의 배수이면서 5의 배수
		System.out.println(dp[n][0]);
	}
}
