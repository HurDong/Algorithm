import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Character> keys;
	static int h, w, answer;
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());

			w = Integer.parseInt(st.nextToken());

			// 테두리를 '.'으로 감싸고 진입 가능하게 한다.
			board = new char[h + 2][w + 2];

			answer = 0;

			for (int i = 1; i <= h; i++) {
				String s = br.readLine();
				for (int j = 1; j <= w; j++) {
					board[i][j] = s.charAt(j - 1);
				}
			}

			for (int i = 0; i <= h + 1; i++) {
				board[i][0] = '.';
				board[i][w + 1] = '.';
			}

			for (int i = 0; i <= w + 1; i++) {
				board[0][i] = '.';
				board[h + 1][i] = '.';
			}

			String s = br.readLine();

			keys = new ArrayList<>();

			if (!s.equals("0")) {
				for (int i = 0; i < s.length(); i++) {
					keys.add(s.charAt(i));
				}
			}

//			for (int i = 0; i <= h + 1; i++) {
//				for (int j = 0; j <= w + 1; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}

			answer = keyGame(0, 0);

			sb.append(answer + "\n");
		}

		System.out.println(sb.toString());
	}

	private static int keyGame(int x, int y) {
		int count = 0;

		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { x, y });

		boolean[][] visited = new boolean[h + 2][w + 2];

		visited[x][y] = true;

		// 먼저 가지고 있는 열쇠를 다 사용하여 갈 수 있는 경로를 최신화한다.
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
//			System.out.println(cur[0] + " " + cur[1]);
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];

				int ny = cur[1] + dy[i];

				// 열쇠를 얻을 때 visited를 다시 초기화 한다.
				if (isRange(nx, ny) && !visited[nx][ny]) {
					// 이동 가능한 일반 칸일 경우 queue 넣고 이동
					if (board[nx][ny] == '.') {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
					// 문서일 경우 count 증가 후 이동
					else if (board[nx][ny] == '$') {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
						board[nx][ny] = '.';
						count++;
					}
					// 열쇠를 획득할 경우 이동 후 열쇠 배열에 추가 및 visited 초기화
					else if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z') {
						queue.add(new int[] { nx, ny });
						visited = new boolean[h + 2][w + 2];
						visited[nx][ny] = true;
						keys.add(board[nx][ny]);
						board[nx][ny] = '.';
					}
					// 문을 만났을 경우 키가 있는지 확인 후 이동
					else if (board[nx][ny] >= 'A' && board[nx][ny] <= 'Z') {
						for (char key : keys) {
							if ((key - 'a') + 'A' == board[nx][ny]) {
								queue.add(new int[] { nx, ny });
								visited[nx][ny] = true;
								board[nx][ny] = '.';
							}
						}
					}
				}
			}
		}
		return count;
	}

	private static boolean isRange(int x, int y) {
		if (x < h + 2 && y < w + 2 && x >= 0 && y >= 0) {
			return true;
		}
		return false;
	}
}
