import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
		int count = 0;
		while (true) {
			open = new boolean[n][n][4];
			visited = new boolean[n][n];
			// true면 이동 없음
			if (move()) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean move() {
		boolean noMove = true;
		// 모든 국가에 대하여 인접 국가와 비교 실시
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (isRange(x, y)) {
						int dif = Math.abs(board[i][j] - board[x][y]);
						if (dif >= l && dif <= r) {
							open[i][j][k] = true; // 현재 국가 방향 open
							open[x][y][k % 2 == 0 ? k + 1 : k - 1] = true; // 인접 국가의 반대 방향 open
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					// true면 인구 이동
					if (bfs(i, j)) {
						noMove = false;
					}
				}
			}
		}
		return noMove;
	}

	private static boolean bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		int sum = board[x][y];
		int count = 1;
		ArrayList<int[]> targets = new ArrayList<>();
		targets.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (isRange(nx, ny) && !visited[nx][ny]) {
					if (open[cur[0]][cur[1]][i] && open[nx][ny][i % 2 == 0 ? i + 1 : i - 1]) {
						visited[nx][ny] = true;
						open[cur[0]][cur[1]][i] = false;
						open[nx][ny][i % 2 == 0 ? i + 1 : i - 1] = false;
						sum += board[nx][ny];
						count++;
						queue.add(new int[] { nx, ny });
						targets.add(new int[] { nx, ny });
					}
				}
			}
		}
		int avg = sum / count;
		for (int i = 0; i < targets.size(); i++) {
			int[] target = targets.get(i);
			board[target[0]][target[1]] = avg;
		}
		if (count == 1) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n)
			return true;
		else
			return false;
	}

}
