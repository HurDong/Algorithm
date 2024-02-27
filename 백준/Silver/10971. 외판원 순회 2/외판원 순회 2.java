import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;

	static int n;

	static int[][] graph;

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		// 인접 행렬로 표현(모든 점을 가야하므로)
		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n + 1];

		visited[1] = true;

		// 사이클을 형성하므로 임의의 점 1에서 출발하여 1로 도착하는 경로를 생각
		dfs(1, 0, 0); // 출발 점

		System.out.println(answer);
	}

	private static void dfs(int node, int count, int sum) {
		if (count == n - 1) {
			// 이전 노드와 출발 점 1이 연결되었을 경우만 답 최신화
			if (graph[node][1] != 0) {
				answer = Math.min(answer, sum + graph[node][1]);
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			// 미방문 노드이면서 서로 연결되어 있는 노드에 대해서 dfs 진행
			if (!visited[i] && graph[node][i] != 0) {
				visited[i] = true;
				dfs(i, count + 1, sum + graph[node][i]);
				visited[i] = false;
			}
		}
	}
}
