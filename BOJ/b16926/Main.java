package b16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, m, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		r = Integer.parseInt(st.nextToken()); // 회전 수

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotate(0);
	}

	private static void rotate(int count) {
		if (count == r) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(board[i][j] + " ");
				}
				sb.append("\n");
			}

			System.out.println(sb.toString());
			System.exit(0);
		}

		int[][] prev = new int[n][m];

		// prev[][]에 board[][]를 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				prev[i][j] = board[i][j];
			}
		}

		boolean[][] visited = new boolean[n][m];

		// 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 더 작은 변의 길이의 반만큼
		for (int k = 0; k <= (n > m ? m / 2 : n / 2); k++) {
			int x = k;

			int y = k;

			int dir = 0; // 초기 dir은 아래

			// min(n,m) mod 2 = 0 이므로 1*2 or 2*1이 남는다고 가정하지 않는다.
			while (isRange(x + dx[dir], y + dy[dir]) && !visited[x + dx[dir]][y + dy[dir]]) {
				x += dx[dir];

				y += dy[dir];

				visited[x][y] = true;

				board[x][y] = prev[x - dx[dir]][y - dy[dir]];

				// 경계 혹은 이미 방문했던 board[][]에 도달하면 방향 전환을 통해 회전 진행
				if (!(isRange(x + dx[dir], y + dy[dir]) && !visited[x + dx[dir]][y + dy[dir]])) {
					if (dir == 3) {
						break;
					} else {
						dir++;
					}
				}
			}
		}
		rotate(count + 1);
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		} else {
			return false;
		}
	}
}
