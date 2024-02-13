package b2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> outCheeze;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	static int n, m, size, temp;

	static boolean[][] visited;

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		// 테두리 생각하여 +2
		board = new int[n + 2][m + 2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시간
		int time = 0;

		while (!noCheeze()) {
			size = 0;

			visited = new boolean[n + 2][m + 2];

			outCheeze = new ArrayList<>();
			time++;

			for (int i = 0; i <= n + 1; i++) {
				bfsAir(i, 0);
				bfsAir(0, i);
			}

			// outCheese에서 하나씩 꺼내어 0으로 초기화
			for (int[] cheeze : outCheeze) {
				board[cheeze[0]][cheeze[1]] = 0;
			}
		}
		System.out.println(time + "\n" + size);
	}

	// 더이상 치즈가 있는 지 없는 지 확인하는 메서드
	private static boolean noCheeze() {
		boolean noCheeze = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (board[i][j] == 1) {
					noCheeze = false;
					size++;
				}
			}
		}
		// cheeze가 없으면 size는 이전 temp
		if (noCheeze) {
			size = temp;
		}
		// cheeze가 있으면 temp를 size로 최신화
		else {
			temp = size;
		}
		return noCheeze;
	}

	private static void bfsAir(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny) && !visited[nx][ny]) {
					// 테두리에서 갈 수 있는 치즈일 경우 경계이므로 삭제 실시
					if (board[nx][ny] == 1) {
						visited[nx][ny] = true;
						outCheeze.add(new int[] { nx, ny });
					}
					// 구멍을 만날 경우 queue에 넣고 bfs 진행
					else if (board[nx][ny] == 0) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}

	}

	// 범위 확인 하는 메서드
	private static boolean isRange(int x, int y) {
		if (x >= 0 && x < n + 2 && y >= 0 && y < m + 2) {
			return true;
		} else
			return false;
	}

}
