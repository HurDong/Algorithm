package b2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // coins 오름차순 정렬
        Arrays.sort(coins);

        int[] dp = new int[k + 1]; // dp[i] : i원을 만들 때 최소 개수

        // 절대 도달못하는 값으로 설정
        Arrays.fill(dp, k + 1);

        dp[0] = 0;

        // dp 로직 ...
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // dp[k]가 k+1 이면 못 만드는 경우
        System.out.println(dp[k] > k ? -1 : dp[k]);
    }
}
