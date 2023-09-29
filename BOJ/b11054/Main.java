package b11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] num = new int[n];
    int[] dp = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    // dp[i] 는 i번째 num을 마지막으로 포함할때의 최대 길이
    // dp[i] 는 오름차순일 때, 내림차순일 때 두 가지중 Max값
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + 1, dp[i - 2] + 1);
    }
    System.out.println(dp[n - 1]);
  }
}
