import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// n가지 종류의 동전이 무수히 많을 때 합이 k가 되게 하는 경우의 수
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k = sc.nextInt();

		int[] coins = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			coins[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(coins);

		// dp[i][j] : 1~i까지의 동전으로 j원 만드는 경우의 수
		int[][] dp = new int[n + 1][k + 1];

		int idx = n;

		for (int i = 1; i <= n; i++) {
			if (coins[i] <= k) {
				dp[i][coins[i]] = 1;
			} else {
				idx = i;
				break;
			}
		}

		for (int i = 1; i <= idx; i++) {
			for (int j = 1; j <= k; j++) {
				if (j > coins[i]) {
					dp[i][j] += dp[i][j - coins[i]] + dp[i - 1][j];
				} else {
					dp[i][j] += dp[i - 1][j];
				}
				// System.out.println(i + " " + j + " " + coins[i] + " " + dp[i][j]);
			}
		}

		System.out.println(dp[idx][k]);
	}

}
