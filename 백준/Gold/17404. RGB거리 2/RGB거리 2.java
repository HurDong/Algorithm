import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] houses = new int[n + 1][3];
        int[][] dp = new int[n + 1][3]; // dp[i] : i번째 집을 그릴 떄까지 최소 / dp[i][j] : i번째 집을 j 색깔로 칠할 때 최소
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }

        // 첫번쨰 집은 두번재 집과 마지막 집과 색깔이 달라야함.
        // 이웃한 집은 색깔이 달라야함
        for (int i = 0; i < 3; i++) {
            // 첫 집에 대한 처리
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = houses[1][j];
                } else {
                    dp[1][j] = 1000001; // 비용의 최댓값은 1000 이므로 1000 * 1000 + 1 로 설정
                }
            }

            // 첫 집 이후에 대한 처리
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + houses[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + houses[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + houses[j][2];
            }

            // 마지막 집에 대한 처리 (첫 집과도 달라야함)
            for (int j = 0; j < 3; j++) {
                // 첫 집과 마지막 집의 색깔이 다를 경우
                if (i != j) {
                    // answer 값 변경
                    answer = Math.min(answer, dp[n][j]);
                }
            }
        }

        System.out.println(answer);

    }

}
