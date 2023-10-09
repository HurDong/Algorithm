import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] wine;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(st.nextToken());
    wine = new int[n];
    dp = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      wine[i] = Integer.parseInt(st.nextToken());
    }
    findBest();
  }

  public static void findBest() {
    int case1 = 0;
    int case2 = 0;
    int case3 = 0;

    // 1) i번째 와인을 마시는 경우
    // i) i-1번째 와인을 마신 i-2번째는 마시면 안된다
    // ii) i-1번째 와인을 마시지않는 경우
    // 2) i번째 와인을 마시지 않는 경우
    // i) i-1번째 와인을 마신 경우 dp[i-1] 그대로 받음
    if (n == 1) {
      System.out.println(wine[0]);
      return;
    } else if (n == 2) {
      System.out.println(wine[0] + wine[1]);
      return;
    }
    // 0,1번째 마시고 2번째 안마시는 경우
    dp[0] = wine[0];
    dp[1] = dp[0] + wine[1];
    dp[2] = dp[1];
    for (int i = 3; i < n; i++) {
      dp[i] =
        Math.max(
          dp[i - 1],
          Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
        );
    }
    case1 = dp[n - 1];

    // 1,2번째 마시는 경우
    dp[0] = 0;
    dp[1] = dp[0] + wine[1];
    dp[2] = dp[1] + wine[2];
    for (int i = 3; i < n; i++) {
      dp[i] =
        Math.max(
          dp[i - 1],
          Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
        );
    }
    case2 = dp[n - 1];

    // 0,2번째 마시는 경우
    dp[0] = wine[0];
    dp[1] = dp[0];
    dp[2] = dp[1] + wine[2];
    for (int i = 3; i < n; i++) {
      dp[i] =
        Math.max(
          dp[i - 1],
          Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
        );
    }
    case3 = dp[n - 1];

    System.out.println(Math.max(case1, Math.max(case2, case3)));
  }
}
