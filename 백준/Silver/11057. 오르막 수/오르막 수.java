import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int DIV = 10007;

	public static void main(String[] args) {
		// 같아도 오름차순으로, 0으로 시작 가능 -> 001 != 1
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// dp[i][j] : i 자리수에서 마지막 수가 j일때
		int[][] dp = new int[n + 1][10];

		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += (dp[i - 1][k]) % DIV;
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[n][i]) % DIV;
		}

		System.out.println(answer);
	}
}
