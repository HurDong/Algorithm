package b16234;

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

		n = Integer.parseInt(st.nextToken()); // 전체 국가 수

		l = Integer.parseInt(st.nextToken()); // 최솟값

		r = Integer.parseInt(st.nextToken()); // 최댓값

		board = new int[n][n]; // 전체 국가 인구 수 저장 배열

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0; // 정답 저장 변수

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

	// 모든 국가에 대하여 각각의 인접 국가와 l이상 r이하인지 확인 후 국경선을 여는 메서드
	private static boolean move() {
		boolean noMove = true; // 이동이 있는지 없는지 확인하는 boolean
		// 모든 국가에 대하여 인접 국가와 비교 실시
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					// 범위 안에 있고
					if (isRange(x, y)) {
						int dif = Math.abs(board[i][j] - board[x][y]);
						// 인접 국가의 차이가 l이상 r이하라면
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
						noMove = false; // 이동이 있었으므로 noMove를 false로
					}
				}
			}
		}

		return noMove;
	}

	// 해당 (x,y) 좌표에 대해 국경선을 연 모든 국가를 찾고 해당 국가의 인구의 합 평균을 각 국가에 할당하는 메서드
	private static boolean bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { x, y });

		visited[x][y] = true;

		int sum = board[x][y]; // 현재 국가를 sum에 먼저 추가

		int count = 1; // (x,y)를 추가

		ArrayList<int[]> targets = new ArrayList<>(); // (x,y)에 대하여 국경선을 연 모든 국가를 담을 배열

		targets.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (isRange(nx, ny) && !visited[nx][ny]) {
					// 국경선을 연 인접 국가에 대하여
					if (open[cur[0]][cur[1]][i] && open[nx][ny][i % 2 == 0 ? i + 1 : i - 1]) {
						visited[nx][ny] = true; // 방문 처리를 하고

						open[cur[0]][cur[1]][i] = false;

						open[nx][ny][i % 2 == 0 ? i + 1 : i - 1] = false;

						sum += board[nx][ny]; // 합계에 해당 국가를 더하고

						count++; // 국가 수를 더하고

						queue.add(new int[] { nx, ny });

						targets.add(new int[] { nx, ny }); // targets에 추가
					}
				}
			}
		}
		// 평균 계산(소수점 버림)
		int avg = sum / count;
		// 모든 국경선 연 국가에 대하여 평균값을 넣어줌
		for (int i = 0; i < targets.size(); i++) {
			int[] target = targets.get(i);
			board[target[0]][target[1]] = avg;
		}
		// 만약 국가 수가 1이라면 noMove를 true로 만들기 위해 false 리턴
		if (count == 1) {
			return false;
		} else {
			return true;
		}
	}

	// 범위를 확인하기 위한 메서드
	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n)
			return true;
		else
			return false;
	}
}