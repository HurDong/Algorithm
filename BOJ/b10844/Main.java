package b10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[][] dp;
  static int n;
  static int MOD = 1000000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[n + 1][10];

    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j + 1];
        } else if (j == 9) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
      }
    }

    int result = 0;
    for (int i = 0; i <= 9; i++) {
      result = (result + dp[n][i]) % MOD;
    }

    System.out.println(result);
  }
}
