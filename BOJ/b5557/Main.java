package b5557;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        // dp[i][j] = 0부터 i까지 수를 사용하여 만든 수의 값이 j일 때 경우의 수
        long[][] dp = new long[n][21];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        dp[0][nums[0]] = 1; // nums[0]을 사용하여 nums[0]을 만들었을 때 경우의 수 : 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    // i번째 수를 더할 때
                    if (j + nums[i] <= 20)
                        dp[i][j + nums[i]] += dp[i - 1][j];
                    // i번째 수를 뺄 때
                    if (j - nums[i] >= 0)
                        dp[i][j - nums[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 2][nums[n - 1]]);
    }
}
