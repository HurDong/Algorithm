import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int[][] triangle = new int[n][n];
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp[0][0] = triangle[0][0];
    // 전 과정에서 최대를 골랐다고 가정.
    for (int i = 1; i < n; i++) {
      dp[i][0] = dp[i - 1][0] + triangle[i][0];
      for (int j = 1; j < i + 1; j++) {
        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
      }
    }
    int result = dp[n - 1][0];
    for (int i = 1; i < n; i++) {
      result = Math.max(result, dp[n - 1][i]);
    }
    System.out.println(result);
  }
}
