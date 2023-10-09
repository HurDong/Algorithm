import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    /*
     * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
     * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
     * 마지막 도착 계단은 반드시 밟아야 한다.
     */
    int n = Integer.parseInt(st.nextToken());
    int[] stair = new int[n + 1];
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      stair[i] = Integer.parseInt(st.nextToken());
    }
    dp[1] = stair[1];
    if (n >= 2) {
      dp[2] = stair[1] + stair[2];
    }

    for (int i = 3; i <= n; i++) { // 전단계 두가지 케이스
      // 1. 두칸전진으로 올때, 2. 한칸전진으로올때(연속3번예외처리)
      dp[i] =
        Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
    }
    System.out.println(dp[n]);
  }
}
