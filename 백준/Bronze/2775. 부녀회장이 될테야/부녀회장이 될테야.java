import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] dp = new int[15][15];
        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        /*
         * 3 1 5 15 35 70
         * 2 1 4 10 20 35
         * 1 1 3 6 10 15
         * 0 1 2 3 4 5
         */
        while (T > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(dp[k][n]);
            T--;
        }
    }
}
