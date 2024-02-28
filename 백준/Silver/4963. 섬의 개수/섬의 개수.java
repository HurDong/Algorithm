import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 팔방 탐색
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int w = 1, h = 1, answer = 0; // w와 h를 1로 초기 세팅하여 처음에 while문을 통과하도록
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		while (w != 0 && h != 0) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());

			w = Integer.parseInt(st.nextToken());

			answer = 0;

			board = new int[w][h];

			visited = new boolean[w][h];

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			sb.append(answer + "\n");
		}
		sb.deleteCharAt(sb.length() - 2); // 마지막 0을 지우기 위한 코드
		System.out.println(sb.toString());
	}

	// 일반적인 bfs + 팔방탐색
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			for (int i = 0; i < 8; i++) {

				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {
					if (!visited[nx][ny] && board[nx][ny] == 1) {

						visited[nx][ny] = true;

						queue.add(new int[] { nx, ny });
					}
				}
			}
		}

		answer++;

	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < w && y < h) {
			return true;
		}
		return false;
	}
}
