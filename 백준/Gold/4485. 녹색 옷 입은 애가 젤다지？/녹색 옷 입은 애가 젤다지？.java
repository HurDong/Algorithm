import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node> {
		int x, y, price;

		public Node(int x, int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return this.price - o.price;
		}

	}

	private static final int INF = Integer.MAX_VALUE;

	static boolean[][] visited;
	static int[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n = -1, idx = 0, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			answer = 0;

			idx++;

			board = new int[n][n];

			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(0, 0);

			sb.append("Problem " + idx + ": " + answer +"\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int x, int y) {
		int[][] sums = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(sums[i], INF);
		}
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(x, y, board[x][y]));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.x == n - 1 && cur.y == n - 1) {
				answer = cur.price;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (isRange(nx, ny)) {
					if (cur.price + board[nx][ny] < sums[nx][ny]) {
						sums[nx][ny] = cur.price + board[nx][ny];
						queue.add(new Node(nx, ny, sums[nx][ny]));
					}
				}
			}
		}

	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n)
			return true;
		else
			return false;
	}

}
