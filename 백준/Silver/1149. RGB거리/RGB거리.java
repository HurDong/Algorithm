import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] dp;
  static int[][] color;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    dp = new int[n][3];
    color = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        color[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    findBest();
  }

  public static void findBest() {
    /*
     * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
     */
    dp[0][0] = color[0][0];
    dp[0][1] = color[0][1];
    dp[0][2] = color[0][2];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + color[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + color[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + color[i][2];
    }
    System.out.println(
      Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])
    );
  }
}
