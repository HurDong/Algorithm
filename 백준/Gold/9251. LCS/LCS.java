import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(LCS(a, b));
    }

    public static int LCS(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int[][] dp = new int[al + 1][bl + 1];
        for (int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[al][bl];
    }

}
