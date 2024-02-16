import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> archers;

	static int[] archer;

	// 좌 상 우만 가능
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	static int n, m, d, count, answer = 0;

	static int[][] board;

	static boolean find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		d = Integer.parseInt(st.nextToken());

		archer = new int[3]; // 궁수의 위치를 저장할 배열

		archers = new ArrayList<>(); // 궁수의 위치의 조합을 저장할 리스트

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 성에 궁수 1명씩 총 3명 배치 가능 ,턴마다 가장 가까운 적 중 왼쪽에 있는 적을 공격
		// 턴이 지나면 모든 적은 아래로 한 칸씩 아래로 가고 성으로 가면 사라짐
		combination(0, 0);

		for (int i = 0; i < archers.size(); i++) {
			castleGame(archers.get(i));
		}

		System.out.println(answer);
	}

	// 완전 탐색을 이용하여 가능한 0 ~ m-1 에 3명의 궁수를 배치하는 조합 설계
	private static void combination(int start, int depth) {
		if (depth == 3) {
			int[] temp = new int[3];

			for (int i = 0; i < 3; i++) {
				temp[i] = archer[i];
			}

			archers.add(temp);

			return;
		}

		for (int i = start; i < m; i++) {
			archer[depth] = i;
			combination(i + 1, depth + 1);
		}

	}

	// 궁수의 조합을 통해 캐슬 디펜스 진행
	private static void castleGame(int[] comb) {
		count = 0;

		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = board[i][j];
			}
		}

		// 가장 왼쪽에 있는 궁수부터 시작하여 턴마다 병사를 죽이는 반복을 실행
		for (int i = 0; i < n; i++) {
			// 같은 적을 조준할 수 있도록 cut에 저장 후 세 궁수 모두 적 조준 한 후에 삭제하도록 HashSet사용
			HashSet<List<Integer>> cut = new HashSet<>();
			// 각각의 궁수에 대하여 bfs를 진행하여 가장 짧으면서 가장 왼쪽에 있는 좌표를 cut에 넣는다.
			for (int j = 0; j < 3; j++) {
				bfs(temp, cut, (n - 1) - i, comb[j]); // 턴이 지남에 따라 병사들이 내려오므로 행의 값을 i만큼 빼준다.
			}
			// HashSet에 있는 좌표를 삭제
			for (List<Integer> list : cut) {
				int x = list.get(0);
				int y = list.get(1);
				temp[x][y] = 0;
			}
			count += cut.size();
		}
		answer = Math.max(answer, count);
	}

	private static void bfs(int[][] temp, HashSet<List<Integer>> cut, int x, int y) {
		// 궁수에서 턴만큼 올린 값에서 바로 위로 출발 ( 좌,우는 가면 안되므로)
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { x, y, 1 });

		// 해당 좌표에 적이 있으면 HashSet에 넣고 return
		if (temp[x][y] == 1) {
			cut.add(Arrays.asList(x, y));
			return;
		}

		boolean[][] visited = new boolean[n][m];

		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			// 거리를 초과한 경우 return
			if (cur[2] + 1 > d) {
				return;
			}

			for (int k = 0; k < 3; k++) {
				int nx = cur[0] + dx[k];

				int ny = cur[1] + dy[k];

				int dist = Math.abs(nx - x) + Math.abs(ny - y) + 1;

				// 범위 안에 있을 경우
				if (isRange(nx, ny)) {
					// 방문하지 않은 좌표라면
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						// 적군이 있고 사정거리 안이라면
						if (temp[nx][ny] == 1 && dist <= d) {
							// HashSet에 좌표를 넣는다.
							cut.add(Arrays.asList(nx, ny));
							return;
						}
						// 적군이 아니라면 지나가야하므로 queue에 좌표와 거리를 넣는다.
						else {
							queue.add(new int[] { nx, ny, dist });
						}
					}
				}
			}
		}
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		}
		return false;
	}

}
