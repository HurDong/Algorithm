package b4485;

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
		// 지출을 최소화하기 위해 price의 오름차순으로 정렬
		public int compareTo(Node o) {
			return this.price - o.price;
		}

	}

	static int[][] board;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	static int n = -1, idx = 0, answer = 0;

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			answer = 0;

			idx++;

			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(0, 0);

			sb.append("Problem " + idx + ": " + answer + "\n");
		}

		System.out.print(sb.toString());

	}

	private static void bfs(int x, int y) {
		// 0,0에서 지출을 최소화하면서 각 좌표로 갈 때의 지출을 저장할 배열
		int[][] sums = new int[n][n];

		// INF로 배열을 채운다.
		for (int i = 0; i < n; i++) {
			Arrays.fill(sums[i], INF);
		}

		// price 오름차순으로 정렬
		Queue<Node> queue = new PriorityQueue<>();

		queue.add(new Node(x, y, board[x][y]));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			// 목표 지점에 도착했을 경우 해당 price를 answer로 변경
			if (cur.x == n - 1 && cur.y == n - 1) {

				answer = cur.price;

				return;
			}

			for (int i = 0; i < 4; i++) {

				int nx = cur.x + dx[i];

				int ny = cur.y + dy[i];

				if (isRange(nx, ny)) {
					// 최솟값을 최신화 후 queue에 저장
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
