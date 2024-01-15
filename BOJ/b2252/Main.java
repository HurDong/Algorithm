package b2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] indegree = new int[n + 1]; // 위상 배열 선언

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b]++; // b가 더 크므로 b의 위상을 증가시킨다.
		}
		// 위상 정렬 알고리즘 시작
		Queue<Integer> queue = new LinkedList<>();
		// 차수가 0인 것부터 큐에 삽입
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int next : graph.get(cur)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
	}

}
