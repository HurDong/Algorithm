package b1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    dp = new int[n + 1];
    System.out.println(find(n));
  }

  public static int find(int n) {
    dp[1] = 0;
    if (n >= 2) {
      dp[2] = 1;
    }
    if (n >= 3) {
      dp[3] = 1;
    }
    // if문으로 dp/3 dp/2 dp-1중 뭐가 더 작은지찾기.
    for (int i = 4; i <= n; i++) {
      if (i % 3 == 0 && i % 2 != 0) {
        dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
      } else if (i % 3 == 0 && i % 2 == 0) {
        dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
      } else if (i % 3 != 0 && i % 2 == 0) {
        dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
      } else {
        dp[i] = dp[i - 1] + 1;
      }
    }
    return dp[n];
  }
}
