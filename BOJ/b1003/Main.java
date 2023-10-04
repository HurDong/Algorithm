package b1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            fibonacci(num);
            sb.append(dp[num][0] + " " + dp[num][1] + "\n");
        }
        System.out.println(sb.toString());
    }

    static public void fibonacci(int n) {
        if (dp[n][0] == 0 && dp[n][1] == 0) {
            fibonacci(n - 1);
            fibonacci(n - 2);
            dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
            dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
        }
    }
}
