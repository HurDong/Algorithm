package b9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static long[] dp = new long[101];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    triangle(1);
    for (int i = 0; i < n; i++) {
      // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, 33
      st = new StringTokenizer(br.readLine());
      sb.append(dp[Integer.parseInt(st.nextToken())] + "\n");
    }
    System.out.println(sb.toString());
  }

  public static void triangle(int n) {
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    for (int i = 6; i <= 100; i++) {
      dp[i] = dp[i - 2] + dp[i - 3];
    }
  }
}
