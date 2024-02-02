import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dist;
	static int[][] dp;
	static int n;
	static int len;
	final static int INF = 16_000_000;

	public static void main(String[] args) {
		// 모든 도시 순회 갔던 도시 방문 불가
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		// dist[i][j] : i부터 j로 가는 비용
		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = sc.nextInt();
			}
		}

		len = (int) Math.pow(2, n) - 1;

		// dp[i][j] : i번째 도시를 갈 때의 비트마스킹 j 일 경우의 최소 비용
		dp = new int[n][len];

		// 최소 비용 계산을 위해 미방문 dp는 -1로 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		// 출발 도시가 달라도 경로가 같으면 최소 비용이 같음 그래서 0을 시작 도시로 넣음.
		System.out.println(dfs(0, 1));
	}

	private static int dfs(int cur, int mask) {
		// 모두 방문하였을 경우
		if (mask == len) {
			// 현재에서 0번 도시로 가는 길이 없으면 실패(0이 시작 도시이므로)
			if (dist[cur][0] == 0)
				return INF;
			// 현재에서 0번 도시로 가는 길이 있으면 그 거리를 리턴
			else
				return dist[cur][0];
		}

		// 방문 dp이면 해당 dp값 return
		if (dp[cur][mask] != -1)
			return dp[cur][mask];
		// 미방문 dp를 INF로 설정
		else
			dp[cur][mask] = INF;

		for (int i = 0; i < n; i++) {
			// mask 비트마스킹만큼 방문 했을 때, i를 방문하지 않았을 경우 && cur에서 i로 가는 경로가 있을때
			if ((mask & (1 << i)) == 0 && dist[cur][i] != 0) {
				// 원래 dp 와 i를 방문하는 dp의 최솟값을 원래 dp에 넣어줌
				dp[cur][mask] = Math.min(dfs(i, mask | (1 << i)) + dist[cur][i], dp[cur][mask]);
			}
		}

		return dp[cur][mask];

	}
}
