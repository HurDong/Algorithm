package b1562;

import java.util.Scanner;

public class Main {
	static final int DIV = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 0부터 9까지 모든 수를 사용하면서 0으로는 시작 안하는 계단 수인 수의 갯수 구하기
		int[][][] dp = new int[n + 1][2][10];
		// dp[i][j][k] : i 자리수에서 j가 0이면 완전한 계단수가 아니고 숫자 k가 안들어간
		// j가 1이면 완전한 계단수 일때
		// 10) 0123456789, 9876543210
		// 11)앞에 1, 앞에 8, 뒤 1->
		// 12) dp[i-2] dp[i-1]

		// 10123456789
		dp[10][1][0] = 1;
		// 1*9 * 8 *8
		for (int i = 1; i <= n; i++) {
		}
		for (int i = 11; i < n; i++) {

		}
	}
}
