import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // lines[i][0] : 전봇대 A / lines[i][0] : 전봇대 B
        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines[i][0] = start;
            lines[i][1] = end;
        }

        // lines[][0](전봇대 A 인덱스)를 기준으로 오름차순 정렬
        Arrays.sort(lines, (a, b) -> a[0] - b[0]);

        // dp[i] : 정렬된 lines의 i번째 전깃줄까지 있을 때 가장 긴 길이의 전깃줄 조합
        // (이를 전체 전깃줄 수에서 빼면 없애야할 최소 전깃줄 return)
        int[] dp = new int[n];

        int answer = 0;

        // lines의 인덱스가 증가함에 따라 lines[] 의 값도 증가해야함 -> LCS 처럼
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            // i > j 인 상황
            for (int j = 0; j < i; j++) {
                // 증가할 때
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(n - answer);
    }

}
