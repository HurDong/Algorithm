package b10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 팰린드롬이란 거꾸로 읽어도 같은 것을 말한다 기러기 토마토 스위스 ...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] : i부터 j까지 펠린드롬인지.

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 길이가 1이면 항상 펠린드롬
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
            dp[i][i] = 1;
        }

        // 길이가 2인 경우를 먼저 생각
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i + 1]) {
                    dp[i][i + 1] = 1;
                } else {
                    dp[i][i + 1] = 0;
                }
            }
        }

        // 길이가 3이상인 경우를 생각
        for (int len = 3; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                // dp[i][j-1] + arr[j] 생각
                if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] + "\n");
        }

        System.out.print(sb.toString());
    }
}
