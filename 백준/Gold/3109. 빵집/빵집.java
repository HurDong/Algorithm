import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	// 우 상우 하우
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	static int r, c;

	static char[][] board;

	static boolean[][] visited;

	static int answer = 0;

	static Stack<Integer> stack = new Stack<>();

	// 최초로 찾았는지
	static boolean find = false;

	public static void main(String[] args) throws IOException {
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
			find = false;
			breadGame(i, 0);
		}
		System.out.println(answer);
	}

	// 먼저 (0,0)에서 시작해서 (r-1,0) 끝이므로 최대한 오른쪽 위를 지향하도록
	private static void breadGame(int x, int y) {
		if (y == c - 1) {
			find = true;
			answer++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!find) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isRange(nx, ny)) {
					if (!visited[nx][ny] && board[nx][ny] == '.') {
						visited[nx][ny] = true;
						breadGame(nx, ny);
					}
				}
			}
		}
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) {
			return true;
		} else
			return false;
	}
}
