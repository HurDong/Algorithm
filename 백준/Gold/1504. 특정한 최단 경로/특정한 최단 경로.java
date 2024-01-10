import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, e, u, v;
	static ArrayList<ArrayList<Node>> list;
	static final int INF = 987654321;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		graph = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
			graph[a][b] = c;
			graph[b][a] = c;
		}
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		// 1->...->u->...->v->...->n
		// 1->...->v->...->u->...->n
		int[] distOne = dijk(1);
		int[] distN = dijk(n);
		int[] distUV = dijk(u);
		int distV = distOne[v] + distN[u] + distUV[v];
		int distU = distOne[u] + distN[v] + distUV[v];
		if (distOne[v] == INF || distOne[u] == INF || distUV[v] == INF || distN[u] == INF || distN[v] == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(Math.min(distV, distU));
	}

	private static int[] dijk(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curVertex = cur.vertex;
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[curVertex][i] != 0 && dist[i] > dist[curVertex] + graph[curVertex][i]) {
					dist[i] = dist[curVertex] + graph[curVertex][i];
					visited[curVertex] = true;
					queue.add(new Node(i, dist[i]));
				}
			}
		}
		return dist;
	}

	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

//	public static class Dist {
//		int dist;
//		boolean pass; // 1->u라고 했을 때 v를 지났는지
//
//		public Dist(int dist, boolean pass) {
//			this.dist = dist;
//			this.pass = pass;
//		}
//	}
}
