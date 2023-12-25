import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for (int i = N; i > 0; i--) {
            // i번째 일에 위치한 상담을 실시한다고 할때
            int next = i + T[i];
            // 상담 종료일시가 N+1을 넘지않아야함
            if (next <= N + 1) {
                dp[i] = Math.max(dp[next] + P[i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[1]);
    }
}
