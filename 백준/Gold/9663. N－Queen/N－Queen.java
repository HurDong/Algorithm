

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] chess;
	static int n;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		chess = new int[n + 1];

		ans = 0;

		nQueen(1);

		System.out.println(ans);

	}

	private static void nQueen(int idx) {
		if (idx > n) {
			ans++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			chess[idx] = i;
			if (checkQueen(idx)) {
				nQueen(idx + 1);
			}
		}
	}

	private static boolean checkQueen(int idx) {
		for (int i = 1; i < idx; i++) {
			if (chess[idx] == chess[i] || Math.abs(chess[idx] - chess[i]) == Math.abs(idx - i)) {
				return false;
			}
		}
		return true;
	}
}