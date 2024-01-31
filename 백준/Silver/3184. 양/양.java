import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 이어진 영역안에서 양의 수가 늑대의 수보다 많으면 늑대를 쫓을 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());

		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];

		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && board[i][j] != '#') {
					bfs(i, j);
				}
			}
		}

		int oSize = 0;

		int vSize = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'o')
					oSize++;
				else if (board[i][j] == 'v')
					vSize++;
			}
		}
		System.out.println(oSize + " " + vSize);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });

		visited[x][y] = true;

		// 양 저장 리스트
		ArrayList<int[]> oList = new ArrayList<>();

		// 늑대 저장 리스트
		ArrayList<int[]> vList = new ArrayList<>();

		if (board[x][y] == 'o')
			oList.add(new int[] { x, y });
		else if (board[x][y] == 'v')
			vList.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				if (isRange(nx, ny)) {
					if (!visited[nx][ny] && board[nx][ny] != '#') {
						if (board[nx][ny] == 'o')
							oList.add(new int[] { nx, ny });
						else if (board[nx][ny] == 'v')
							vList.add(new int[] { nx, ny });

						visited[nx][ny] = true;

						queue.add(new int[] { nx, ny });
					}
				}
			}
		}

		// 양의 수가 늑대의 수보다 많으면 늑대를 .으로 교체
		if (oList.size() > vList.size()) {
			for (int[] v : vList) {
				board[v[0]][v[1]] = '.';
			}
		}

		// 양의 수가 늑대의 수보다 같거나 작으면 양을 .으로 교체
		else {
			for (int[] o : oList) {
				board[o[0]][o[1]] = '.';
			}
		}

	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c)
			return true;
		else
			return false;
	}
}
