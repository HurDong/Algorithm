import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        for (int i = 1; i < 100; i++) {
            dp[i] = i;
        }
        for (int i = 100; i < 1000; i++) {
            int n1 = i / 100;
            int n2 = (i % 100) / 10;
            int n3 = i % 10;
            dp[i] = dp[i - 1];
            if (n1 > n2) {
                int dif = n1 - n2;
                if (n2 - n3 == dif)
                    dp[i]++;
            } else if (n1 == n2) {
                if (n2 == n3)
                    dp[i]++;
            } else {
                int dif = n2 - n1;
                if (n3 - n2 == dif)
                    dp[i]++;
            }
        }
        dp[1000] = dp[999];
        System.out.println(dp[n]);
    }
}
