import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] use = new int[n]; // 사용 비용
		int[] off = new int[n]; // 비활성화 비용

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		// 값 입력
		for (int i = 0; i < n; i++) {
			use[i] = Integer.parseInt(st.nextToken());
			off[i] = Integer.parseInt(st2.nextToken());
		}

		// dp[i][j] : i번째 앱까지 활용 가능하고 j 바이트만큼 off 비용 사용할 때의 최대 use 비용
		// off의 최댓값이 100이므로 n의 최댓값인 100을 곱해준다.
		int[][] dp = new int[n][10001];

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < 10001; i++) {
			if (off[0] <= i)
				dp[0][i] = use[0];
			if (dp[0][i] >= m) {
				answer = Math.min(answer, i);
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 10001; j++) {
				if (j - off[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - off[i]] + use[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
				if (dp[i][j] >= m) {
					answer = Math.min(answer, j);
				}
			}
		}

		System.out.println(answer);
	}
}
