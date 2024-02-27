import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

		graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0, 0); // 출발 점
		System.out.println(answer);
	}

	private static void dfs(int node, int count, int sum) {
		if (count == n - 1) {
			if (graph[node][1] != 0) {
				answer = Math.min(answer, sum + graph[node][1]);
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[node][i] != 0) {
				visited[i] = true;
				dfs(i, count + 1, sum + graph[node][i]);
				visited[i] = false;
			}
		}
	}
}
