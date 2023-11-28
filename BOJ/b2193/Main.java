package b2193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1]; // int가 아닌 long으로!!!
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            // i-1가 0으로 끝난 경우 : dp[i-1]인 경우
            // i-1가 1으로 끝난 경우 : dp[i-2] + '1' 추가한 경우
        }
        System.out.println(dp[n]);
    }
}
