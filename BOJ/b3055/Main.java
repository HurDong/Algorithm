package b3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] board;
	static int[][] wBoard;
	static int tx, ty;
	static List<int[]> water;

	public static void main(String[] args) throws IOException {
		// 먼저 새로운 board에 물이 언제 찰지 시간을 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());

		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];

		wBoard = new int[r][c];

		// 넘치지 않은 것은 -1로 세팅
		for (int i = 0; i < r; i++) {
			Arrays.fill(wBoard[i], Integer.MAX_VALUE);
		}

		water = new ArrayList<>();

		int x = 0;

		int y = 0;

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'S') {
					x = i;
					y = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'D') {
					tx = i;
					ty = j;
				} else if (board[i][j] == '*') {
					water.add(new int[] { i, j });
				}
			}
		}

		setWater();

		bfs(x, y);

		System.out.println("KAKTUS");
	}

	// wBoard에 저장된 시간에 따른 물 확산을 고려하여 bfs 실시
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		boolean[][] visited = new boolean[r][c];

		queue.add(new int[] { x, y, 0 });

		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			// 굴 찾으면 시간 출력 후 시스템 종료
			if (cur[0] == tx && cur[1] == ty) {
				System.out.println(cur[2]);

				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {
					// 다음에 갈 곳이 물이 찰 예정이 아니면서 평지or굴이여야함
					if (!visited[nx][ny] && (board[nx][ny] == '.' || board[nx][ny] == 'D')
							&& wBoard[nx][ny] > cur[2] + 1) {
						queue.add(new int[] { nx, ny, cur[2] + 1 });

						visited[nx][ny] = true;
					}
				}

			}
		}
	}

	// water배열에서 시간이 지남에 따라 넘치는 것을 세팅
	private static void setWater() {
		Queue<int[]> queue = new ArrayDeque<>();

		boolean[][] visited = new boolean[r][c];

		for (int[] w : water) {
			queue.add(new int[] { w[0], w[1], 0 });

			wBoard[w[0]][w[1]] = 0;

			visited[w[0]][w[1]] = true;
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {
					if (!visited[nx][ny] && board[nx][ny] == '.') {
						wBoard[nx][ny] = cur[2] + 1;

						queue.add(new int[] { nx, ny, cur[2] + 1 });

						visited[nx][ny] = true;
					}
				}
			}
		}
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) {
			return true;
		} else {
			return false;
		}
	}
}
