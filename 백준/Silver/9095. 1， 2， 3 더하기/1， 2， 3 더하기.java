import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[11];
        dp[0] = 1;
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1 2
        dp[3] = 4; // 1+1+1 1+2 2+1 3
        // dp[i] = dp[i-1] * 1이 몇개 겹치는지 확인 + dp[i-2] * 2가 몇개 겹치는지 확인 + dp[i-3] * 3이 몇개
        // 겹치는 지 확인;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }

}
