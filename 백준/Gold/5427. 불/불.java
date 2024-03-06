import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static ArrayList<int[]> fires;

	static char[][] board;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());

			w = Integer.parseInt(st.nextToken());

			board = new char[w][h];

			fires = new ArrayList<>();

			int x = 0;

			int y = 0;

			for (int i = 0; i < w; i++) {
				String s = br.readLine();
				for (int j = 0; j < h; j++) {
					board[i][j] = s.charAt(j);
					// 상근이 위치 저장
					if (board[i][j] == '@') {
						board[i][j] = '.'; // 일반 칸으로 변경
						x = i;
						y = j;
					}
					// 불의 위치를 fires에 저장
					else if (board[i][j] == '*') {
						fires.add(new int[] { i, j });
					}
				}
			}
			if (x == 0 || y == 0 || x == w - 1 || y == h - 1)
				sb.append("1\n");
			else
				bfs(x, y);
		}
		System.out.print(sb.toString());
	}

	// 시간이 지남에 따라 불이 옮겨지는 걸 저장해야함.
	private static void bfs(int x, int y) {
		// 불을 먼저 bfs를 통해 몇초에 퍼지는지 계산
		int[][] temp = new int[w][h]; // 시간을 저장할 임시 배열

		boolean[][] tempVisited = new boolean[w][h];

		Queue<int[]> tempQueue = new LinkedList<>();

		// 초기 시간을 -1로 먼저 설정
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				temp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int[] arr : fires) {
			tempQueue.add(new int[] { arr[0], arr[1], 0 }); // 초기는 0초

			tempVisited[arr[0]][arr[1]] = true;

			temp[arr[0]][arr[1]] = 0;
		}

		while (!tempQueue.isEmpty()) {

			int[] cur = tempQueue.poll();

			for (int i = 0; i < 4; i++) {

				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {

					if (!tempVisited[nx][ny] && board[nx][ny] == '.') {

						tempVisited[nx][ny] = true;

						temp[nx][ny] = cur[2] + 1;

						tempQueue.add(new int[] { nx, ny, cur[2] + 1 });
					}
				}
			}
		}

		int time = Integer.MAX_VALUE;

		Queue<int[]> queue = new LinkedList<>();

		boolean[][] visited = new boolean[w][h];

		queue.add(new int[] { x, y, 0 }); // 0초 일때 가능한 상근이의 위치

		visited[x][y] = true;
		// 그런 후 상근이의 위치를 옮기면서 초에 해당하는 board가 불에 탔는지 안 탔는지 체크
		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {

				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {
					if (!visited[nx][ny] && board[nx][ny] == '.' && temp[nx][ny] > cur[2] + 1) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny, cur[2] + 1 });
						if (nx == 0 || ny == 0 || nx == w - 1 || ny == h - 1) {
							time = Math.min(time, cur[2] + 2);
						}
					}
				}
			}
		}

		if (time == Integer.MAX_VALUE) {
			sb.append("IMPOSSIBLE\n");
		} else {
			sb.append(time + "\n");
		}
	}

	private static void print(int[][] temp) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
			return true;
		} else {
			return false;
		}
	}
}
