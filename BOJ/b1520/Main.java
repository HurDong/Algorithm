package b1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] boards;
	static int[][] dp;
	static int n, m;
	static int answer = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 더 낮은 곳으로만 이동 (0,0)에서 (n,m)으로 가는 경우의 수 구하기
		// 시간 초과로 인해 dfs 포기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		boards = new int[n][m];

		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				boards[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // 미방문
			}
		}

		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		if (x == n - 1 && y == m - 1) {
			return 1;
		}
		// 이미 방문했으면 해당 값 return
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0; // 방문으로 처리

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				// 내리막길일 경우
				if (boards[x][y] > boards[nx][ny]) {
					// 해당 dp 에 경로 경우의 수 추가
					dp[x][y] += dfs(nx, ny);
				}
			}
		}

		return dp[x][y];
	}
}
