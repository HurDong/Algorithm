package b17626;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (Math.pow(sqrt, 2) == i) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
