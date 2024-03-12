import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int n = s.length();

		int r = 0, c = 0;

		// 메세지의 길이에서 가장 큰 r을 구한다.
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				r = i;
				c = n / r;
			}
		}

		char[][] board = new char[r][c];

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				board[j][i] = s.charAt(i * r + j);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(board[i][j]);
			}
		}
		System.out.println(sb.toString());
	}
}
