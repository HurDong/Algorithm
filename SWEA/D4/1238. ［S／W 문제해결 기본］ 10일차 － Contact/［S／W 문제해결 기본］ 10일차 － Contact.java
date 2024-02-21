import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph;
	static int size;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			size = 0;
			answer = 0;
			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
			}
			bfs(start, new boolean[101]);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int start, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { start, 0 });
		visited[start] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < graph.get(cur[0]).size(); i++) {
				if (!visited[graph.get(cur[0]).get(i)]) {
					visited[graph.get(cur[0]).get(i)] = true;
					queue.add(new int[] { graph.get(cur[0]).get(i), cur[1] + 1 });
				}
			}
			if (size < cur[1]) {
				size = cur[1];
				answer = cur[0];
			} else if (size == cur[1]) {
				answer = Math.max(answer, cur[0]);
			}
		}

	}
}
