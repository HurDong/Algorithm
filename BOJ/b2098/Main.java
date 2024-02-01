package b2098;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 모든 도시 순회 갔던 도시 방문 불가
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = sc.nextInt();
			}
		}

		// dp[i][j][k] : i에서 j로 갈 때 k(비트) 방문여부
		int[][][] dp = new int[n + 1][n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
				}
			}
		}
	}
}
