import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<Node> graph;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		// 마을을 두 구역으로 나눈다 -> 무조건 하나이상의 집이 포함되어야함
		// 모든 집이 어떻게든 연결되어야 한다. (초기에 모두 연결되어 있다고 가정)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Node(a, b, c));
		}

		Collections.sort(graph); // 간선의 크기 오름차순으로 graph 정렬

		int sum = 0;
		int max = 0;

		for (Node node : graph) {
			if (find(node.start) != find(node.end)) {
				sum += node.price;
				max = node.price; // 오름차순으로 정렬되어 있으므로 마지막 node.price는 max가 될 것.
				union(node.start, node.end);
			}
		}
		
		// sum - max를 최소 비용으로 마을을 2개로 나눌 수 있다.
		System.out.println(sum - max);

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parents[x] = y;
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	public static class Node implements Comparable<Node> {
		int start, end, price;

		public Node(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return this.price - o.price;
		}

	}

}
