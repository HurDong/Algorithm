package b1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Street>> graph;
	static int answer = 0;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		// 지름길은 일방통행 -> 운전 최솟값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int d = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());

			int end = Integer.parseInt(st.nextToken());

			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Street(end, weight));
		}

		dijkstra();
	}

	private static void dijkstra() {

	}

	public static class Street implements Comparable<Street> {
		int vertex, weight;

		public Street(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Street o) {
			return this.weight - o.weight;
		}

	}
}
