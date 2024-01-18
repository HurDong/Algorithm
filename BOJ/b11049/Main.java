package b11049;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		// dp[i][j] : i번째 행렬부터 j번째 행렬까지 있을 때 최소 곱
		int[][] dp = new int[n][n];

		for (int k = 1; k < n; k++) {
			for (int i = 0; i + k < n; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++) {
					dp[i][i + k] = Math.min(dp[i][i + k],
							dp[i][j] + dp[j + 1][i + k] + list.get(i)[0] * list.get(i)[1] * list.get(i + k)[1]);
				}
			}
		}

		System.out.println(dp[0][n - 1]);
	}
}