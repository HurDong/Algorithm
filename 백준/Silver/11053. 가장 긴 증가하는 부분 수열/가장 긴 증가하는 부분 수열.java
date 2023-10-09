import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] num;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(st.nextToken());
    num = new int[n];
    dp = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }
    findLong();
  }

  public static void findLong() {
    // dp가 애초에 i번째 값을 무조건 포함한 부분수열로 보자.
    // 이전의 dp의 최댓값을 구한다. -> 최댓값보다 클경우 실시 아닐경우 i+1
    int max = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (num[j] < num[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}
