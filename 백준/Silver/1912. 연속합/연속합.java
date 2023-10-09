import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] dp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new int[n];
    dp = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    int max = dp[0];

    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
