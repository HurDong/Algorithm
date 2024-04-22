import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static char[][] board;
	static int[] center, goal;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new char[n][n];
		visited = new boolean[n][n][2];
		List<int[]> b = new ArrayList<>();
		List<int[]> e = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'B') {
					b.add(new int[] { i, j });
					board[i][j] = '0';
				} else if (board[i][j] == 'E') {
					e.add(new int[] { i, j });
					board[i][j] = '0';
				}
			}
		}
		center = b.get(1);
		goal = e.get(1);
		int dir = b.get(0)[0] == b.get(1)[0] ? 0 : 1;
		int eDir = e.get(0)[0] == e.get(1)[0] ? 0 : 1;

		bfs(center[0], center[1], dir, eDir);
	}

	private static void bfs(int startX, int startY, int startDir, int eDir) {
		queue.offer(new int[] { startX, startY, startDir, 0 });
		visited[startX][startY][startDir] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int dir = current[2];
			int count = current[3];

			if (x == goal[0] && y == goal[1] && dir == eDir) {
				System.out.println(count);
				return;
			}

			// 이동 및 회전 로직 구현
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nx1 = (dir == 0) ? nx : nx - 1;
				int nx2 = (dir == 0) ? nx : nx + 1;
				int ny1 = (dir == 0) ? ny - 1 : ny;
				int ny2 = (dir == 0) ? ny + 1 : ny;

				if (isRange(nx, ny) && isRange(nx1, ny1) && isRange(nx2, ny2) && !visited[nx][ny][dir]) {
					visited[nx][ny][dir] = true;
					queue.offer(new int[] { nx, ny, dir, count + 1 });
				}
			}

			int newDir = 1 - dir; // 방향 전환
			if (!visited[x][y][newDir] && canRotate(x, y)) {
				visited[x][y][newDir] = true;
				queue.offer(new int[] { x, y, newDir, count + 1 });
			}
		}
		System.out.println(0);
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n && board[x][y] == '0';
	}

	private static boolean canRotate(int cx, int cy) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!isRange(cx + i, cy + j))
					return false;
			}
		}
		return true;
	}
}
