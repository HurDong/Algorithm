import java.util.Scanner;

public class Main {
	static final int DIV = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 0부터 9까지 모든 수를 사용하면서 0으로는 시작 안하는 계단 수인 수의 갯수 구하기
		// dp[i][j][k] : i번째자리까지 있을 때 마지막 자릿수가 j일 때 비트마스킹 값 k
		// 비트마스킹 : 00 0000 0000 (2진수)가 있을 때 1을 사용하면 00 0000 0010
		// 9를 사용하면 10 0000 0000 이렇게 마킹을 하여 0~9 사용 여부를 체크
		int[][][] dp = new int[n + 1][10][1024];

		// 1번째 자리는 각 j값만큼 초기화
		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 1024; k++) {
					// k 비트만큼 채워진 곳에 j번째에 1비트를 추가
					int bit = k | (1 << j);

					// i-1번째 까지 비트마스킹 상태가 k 일때 -> i번째에 j를 넣으면 수 j에 해당하는 비트마스킹만큼 더해주면 된다.

					// 0 일 경우 1만 들어갈 수 있음
					if (j == 0) {
						dp[i][j][bit] += (dp[i - 1][j + 1][k]) % DIV;
					}
					// 9일 경우 8만 들어갈 수 있음
					else if (j == 9) {
						dp[i][j][bit] += (dp[i - 1][j - 1][k]) % DIV;
					}
					// 그 외의 값인 경우 -1 +1 값 들어갈 수 있음
					else {
						dp[i][j][bit] += (dp[i - 1][j - 1][k] % DIV + dp[i - 1][j + 1][k] % DIV) % DIV;
					}

					dp[i][j][bit] %= DIV;
				}
			}
		}

		long sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += dp[n][i][(1 << 10) - 1] % DIV;
			sum %= DIV;
		}

		System.out.println(sum);
	}
}
