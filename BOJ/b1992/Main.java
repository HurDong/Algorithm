package b1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int board[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 언제나 2의 제곱수

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		quadTree(0, 0, n);

		System.out.println(sb.toString());
	}

	// 해당 2차원 배열이 모두 같은 숫자인지 확인하는 메서드
	private static boolean chk(int x, int y, int size) {
		int num = board[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (num != board[i][j])
					return false;
			}
		}
		return true;
	}

	// 해당 2차원 배열이 모두 같은 확인 후 다르다면 4분할하여 재귀하는 메서드
	private static void quadTree(int x, int y, int size) {
		// 모두 같다면 return
		if (chk(x, y, size)) {
			sb.append(board[x][y]);
			return;
		}
		sb.append('(');
		quadTree(x, y, size / 2); // 1사분면
		quadTree(x, y + size / 2, size / 2); // 2사분면
		quadTree(x + size / 2, y, size / 2); // 3사분면
		quadTree(x + size / 2, y + size / 2, size / 2); // 4사분면
		sb.append(')');
	}
}
