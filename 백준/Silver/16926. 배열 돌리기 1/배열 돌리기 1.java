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

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void rotate(int count) {
		if (count == r) {
			return;
		}

		int[][] prev = new int[n][m];

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

			boolean isLoop = true; // 1*2 or 2*1의 경우 무한 루프

			while (isRange(x + dx[dir], y + dy[dir]) && !visited[x + dx[dir]][y + dy[dir]]) {
				isLoop = false;

				x += dx[dir];

				y += dy[dir];

				visited[x][y] = true;

				board[x][y] = prev[x - dx[dir]][y - dy[dir]];

				if (!(isRange(x + dx[dir], y + dy[dir]) && !visited[x + dx[dir]][y + dy[dir]])) {
					if (dir == 3) {
						break;
					} else {
						dir++;
					}
				}
			}
//			if (isLoop) {
//				if (n > m) {
//
//				}
//			}
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
