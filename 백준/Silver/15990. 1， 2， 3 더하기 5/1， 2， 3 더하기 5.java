import java.util.Scanner;

public class Main {
	final static int INF = 100001;
	final static int DIV = 1000000009;

	public static void main(String[] args) {
		// 같은 수를 연속 두 번 사용 X
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		// dp[i][j] : 자연수 i를 표현할 때 마지막 수가 j
		int[][] dp = new int[INF][4];

		dp[1][1] = 1; // 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 2+1
		dp[3][2] = 1; // 1+2
		dp[3][3] = 1; // 3

		for (int i = 4; i < INF; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % DIV;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % DIV;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % DIV;
		}

		while (T-- > 0) {
			int n = sc.nextInt();
			sb.append(((dp[n][1] + dp[n][2]) % DIV + dp[n][3]) % DIV + "\n");
		}
		System.out.println(sb.toString());
	}
}
