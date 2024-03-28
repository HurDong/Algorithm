import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] degree;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		// 단방향 비순환 그래프
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 위상 배열(여기서는 먼저 풀어야할 문제의 위상을 작게)
		degree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			int b = Integer.parseInt(st.nextToken());

			// 그래프에 방향성을 가진채로 a와 b를 연결
			graph.get(a).add(b);

			// a를 먼저 풀어야하므로 b의 위상을 증가
			degree[b]++;
		}

		// 여기서는 먼저 풀어야하는 문제의 조건이 상시로 변경되므로 우선순위큐 사용
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			// 먼저 풀어야되는 문제부터 queue에 추가
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " "); // 정답 출력에 추가
			for (int next : graph.get(cur)) {
				degree[next]--; // 위상 감소를 통해 먼저 풀어야될 우선순위 정렬
				// 먼저 풀어야 된다면 queue에 추가(문제 번호가 낮은 순으로 정렬)
				if (degree[next] == 0) {
					queue.add(next);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
