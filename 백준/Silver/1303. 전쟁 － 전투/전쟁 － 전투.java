import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// n명 뭉쳐있으면 n^2의 위력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		boolean[][] visited = new boolean[n][m];

		int countB = 0;
		int countW = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					int size = 1;
					int[] dx = { -1, 1, 0, 0 };
					int[] dy = { 0, 0, -1, 1 };
					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nx = cur[0] + dx[k];
							int ny = cur[1] + dy[k];
							if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
								if (!visited[nx][ny] && board[nx][ny] == board[i][j]) {
									size++;
									visited[nx][ny] = true;
									queue.add(new int[] { nx, ny });
								}
							}
						}
					}
					if (board[i][j] == 'B') {
						countB += size * size;
					} else {
						countW += size * size;
					}
				}
			}
		}
		System.out.println(countW + " " + countB);
	}
}
