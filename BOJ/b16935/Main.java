package b16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, m, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		r = Integer.parseInt(st.nextToken()); // 회전 수

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int type = Integer.parseInt(br.readLine());

		rotate(0, type);
	}

	private static void rotate(int count, int type) {
		if (count == r) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(board[i][j] + " ");
				}
				sb.append("\n");
			}

			System.out.println(sb.toString());
			System.exit(0);
		}

		switch (type) {
		// 상하 반전
		case 1:
			break;
		// 좌우 반전
		case 2:
			break;
		// 오른쪽 90도 회전
		case 3:
			break;
		// 왼쪽 90도 회전
		case 4:
			break;
		// 4그룹으로 나눈 후 시계 방향 회전
		case 5:
			break;
		// 4그룹으로 나눈 후 반시계 방향 회전
		default:
			break;
		}

		rotate(count + 1, type);
	}

	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		} else {
			return false;
		}
	}
}
