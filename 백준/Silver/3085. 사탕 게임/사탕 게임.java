import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int n;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		board = new int[n][n];

		// 색깔에 맞는 값 넣기 빨 : 1 / 파 : 2 / 초 : 3 / 노 : 4
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				char ch = s.charAt(j);
				switch (ch) {
				case 'C':
					board[i][j] = 1; // 빨
					break;
				case 'P':
					board[i][j] = 2; // 파
					break;
				case 'Z':
					board[i][j] = 3; // 초
					break;
				case 'Y':
					board[i][j] = 4; // 노
					break;
				default:
					break;
				}
			}
		}

		// 모든 케이스에 대해 생각해본다. (교환 1번 가능하다고 가정)
		int[] dx = { 1, 0 };
		int[] dy = { 0, 1 };

		int answer = 0;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				for (int k = 0; k < 2; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
						// 범위 안에 있으면 swap
						int temp1 = board[nx][ny];
						board[nx][ny] = board[x][y];
						board[x][y] = temp1;
						answer = Math.max(checkCandy(), answer);
						// 다시 원상태로
						int temp2 = board[nx][ny];
						board[nx][ny] = board[x][y];
						board[x][y] = temp2;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static int checkCandy() {
		// 빨 : 1 / 파 : 2 / 초 : 3 / 노 : 4
		int[] size = new int[5];

		for (int i = 0; i < n; i++) {
			int colorR = board[i][0];
			int colorC = board[0][i];
			int countR = 1;
			int countC = 1;
			for (int j = 1; j < n; j++) {
				if (colorR == board[i][j]) {
					countR++;
				} else {
					size[colorR] = Math.max(size[colorR], countR);
					countR = 1;
					colorR = board[i][j];
				}
				if (colorC == board[j][i]) {
					countC++;
				} else {
					size[colorC] = Math.max(size[colorC], countC);
					countC = 1;
					colorC = board[j][i];
				}
			}
			size[colorR] = Math.max(size[colorR], countR);
			size[colorC] = Math.max(size[colorC], countC);
		}
//		System.out.println("**********");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= 4; i++) {
//			System.out.print(size[i] + " ");
//		}
//		System.out.println();
//		System.out.println("**********");
		return Math.max(size[1], Math.max(size[2], Math.max(size[3], size[4])));
	}
}
