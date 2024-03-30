package b1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		// 열쇠를 먹으면 해당 칸 .으로 바꾸는거 생각, 0또한 처리 생각
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];

		int startX = 0, startY = 0;

		for (int i = 0; i < n; i++) {

			String s = br.readLine();

			for (int j = 0; j < m; j++) {

				board[i][j] = s.charAt(j);

				if (board[i][j] == '0') {

					startX = i;

					startY = j;

					board[i][j] = '.';
				}
			}
		}

		System.out.println(bfs(startX, startY));

	}

	private static int bfs(int startX, int startY) {

		Queue<int[]> queue = new ArrayDeque<>();

		// 비트마스킹을 위한 3차원 배열 선언
		boolean[][][] visited = new boolean[n][m][(int) Math.pow(2, 6)];

		queue.add(new int[] { startX, startY, 0, 0 }); // ( x, y, bit, dist) 순

		visited[startX][startY][0] = true;

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			int x = cur[0];

			int y = cur[1];

			int bit = cur[2];

			int dist = cur[3];

			for (int i = 0; i < 4; i++) {

				int nx = x + dx[i];

				int ny = y + dy[i];

				if (isRange(nx, ny)) {
					if (!visited[nx][ny][cur[2]]) {
						if (board[nx][ny] == '.') {

							visited[nx][ny][cur[2]] = true;

							queue.add(new int[] { nx, ny, bit, dist + 1 });

						} else if (board[nx][ny] == 'a' || board[nx][ny] == 'b' || board[nx][ny] == 'c'
								|| board[nx][ny] == 'd' || board[nx][ny] == 'e' || board[nx][ny] == 'f') {

							visited[nx][ny][cur[2]] = true;

							int num = 1 << (board[nx][ny] - 'a');

							queue.add(new int[] { nx, ny, cur[2] | num, dist + 1 });

						} else if (board[nx][ny] == 'A' || board[nx][ny] == 'B' || board[nx][ny] == 'C'
								|| board[nx][ny] == 'D' || board[nx][ny] == 'E' || board[nx][ny] == 'F') {

							int num = 1 << (board[nx][ny] - 'A' + 'a' - 1);

							if ((num & cur[2]) == num) {
								visited[nx][ny][cur[2]] = true;

								queue.add(new int[] { nx, ny, cur[2], dist + 1 });
							}

						} else if (board[nx][ny] == '1') {
							return dist + 1;
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		} else {
			return false;
		}
	}
}