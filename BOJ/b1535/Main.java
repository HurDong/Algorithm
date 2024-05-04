package b1535;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] L = new int[n];

        int[] J = new int[n];

        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            J[i] = sc.nextInt();
        }

        // dp[i][j] : 0~i번째까지 사용했을 때 누적된 체력 j일 때 최대 기쁨
        int[][] dp = new int[n][100];

        // 초기값 설정
        for (int j = L[0]; j < 100; j++) {
            dp[0][j] = J[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 100; j++) {
                dp[i][j] = dp[i - 1][j];
                // 인사가 가능할 때
                if (j + L[i] < 100) {
                    // 인사 하고 안하고 중에 더 큰 값 입력
                    dp[i][j + L[i]] = Math.max(dp[i - 1][j] + J[i], dp[i][j + L[i]]);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}
