package b16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, l, r;
	static int[][] board;
	static boolean[][][] open;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// l < 인구 차이 < r 이면 국경 오픈 -> 인접한칸도 국경 오픈이면 연합 -> 각 칸의 인구수 = (연합 인구 수)/(연합 수)
		while (true) {
			bfs();
		}
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[0][0] = true;
		queue.add(new int[] { 0, 0 });
		visited = new boolean[n][n];
		open = new boolean[n][n][4];
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (isRange(nx, ny) && !visited[nx][ny]) {
					int dif = Math.abs(board[cur[0]][cur[1]] - board[nx][ny]);
					int dir = (i + 2) % 4;
					if (dif >= l && dif <= r) {
						open[cur[0]][cur[1]][i] = true;
						open[cur[0]][cur[1]][dir] = true;
					}
				}
			}
		}
		// open
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n)
			return true;
		else
			return false;
	}

}
