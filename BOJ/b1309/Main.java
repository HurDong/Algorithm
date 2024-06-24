package b1309;

import java.util.Scanner;

public class Main {
    final static int DIV = 9901;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // dp[i][0] : 그 칸에 사자 배치 X [1] : 왼쪽에 배치 [2] : 오른쪽에 배치
        int[][] dp = new int[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % DIV; // 상관 X
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV; // 전칸에서 왼쪽 배치만 제외
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV; // 전칸에서 오른쪽 배치만 제외
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % DIV);
    }
}
