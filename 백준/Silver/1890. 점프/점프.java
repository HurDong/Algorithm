import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		// 무조건 오른쪽 or 아래로만 , 점프 중 방향전환 불가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp[i][j] : (i,j) 칸으로 가기 위한 경로의 수 (값이 커질 거 같아 long으로 변경)
		long[][] dp = new long[n][n];

		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!(i == n - 1 && j == n - 1)) {
					if (i + board[i][j] < n) {
						dp[i + board[i][j]][j] += dp[i][j];
					}
					if (j + board[i][j] < n) {
						dp[i][j + board[i][j]] += dp[i][j];
					}
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[n - 1][n - 1]);

	}
}
