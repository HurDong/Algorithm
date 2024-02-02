import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	static int n, m, k, x;
	static ArrayList<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(st.nextToken());

		x = Integer.parseInt(st.nextToken());

		// 단방향 도로 도로의 거리는 모두 1
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// start 정점에 대하여 end 정점에 대한 단방향 도로 생성
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());

			int end = Integer.parseInt(st.nextToken());

			graph.get(start).add(end);
		}

		dijkstra(x);

		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.add(start);

		boolean[] visited = new boolean[n + 1];

		visited[start] = true;

		int dist = 0;

		while (true) {
			Queue<Integer> temp = new ArrayDeque<>();
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				visited[cur] = true;
				for (int end : graph.get(cur)) {
					if (!visited[end]) {
						temp.add(end);
						visited[end] = true;
					}
				}
			}
			dist++;
			if (dist == k) {
				if (temp.isEmpty()) {
					sb.append("-1\n");
				} else {
					ArrayList<Integer> list = new ArrayList<>(temp);
					Collections.sort(list);
					for (int node : list) {
						sb.append(node + "\n");
					}
				}
				return;
			}
			queue = temp;
		}
	}
}