package b11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 오른쪽 , 아래 , 대각선으로만 갔을 때 사탕의 최댓값
		int[][] dp = new int[n][m];

		int[] dx = { 1, 0, 1 };
		int[] dy = { 0, 1, 1 };

		dp[0][0] = board[0][0];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i > 0 && j > 0) {
					dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + board[i][j];
				} else if (i == 0 && j > 0) {
					dp[i][j] = dp[i][j - 1] + board[i][j];
				} else if (i > 0 && j == 0) {
					dp[i][j] = dp[i - 1][j] + board[i][j];
				}
			}
		}
		System.out.println(dp[n - 1][m - 1]);
	}
}
