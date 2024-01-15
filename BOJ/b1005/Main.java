package b1005;

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

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] buildings = new int[n + 1];
			int[] indegree = new int[n + 1]; // 위상 정렬을 위한 배열
			int[] sums = new int[n + 1]; // 각 건물을 짓는데 걸리는 시간을 저장
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
				graph.add(new ArrayList<>());
			}

			// n까지 해야하므로 graph 하나 더 추가
			graph.add(new ArrayList<>());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				indegree[b]++;
			}

			int w = Integer.parseInt(br.readLine());

			Queue<Integer> queue = new LinkedList<>();

			queue.add(w);

			for (int i = 1; i <= n; i++) {
				sums[i] = buildings[i];
				if (indegree[i] == 0) {
					queue.add(i);
				}
			}

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph.get(cur)) {
					// 최대 시간까지 기다려야함.
					sums[next] = Math.max(sums[next], sums[cur] + buildings[next]);
					// 차수 낮추고 0이면 queue에 등록 아니라면 그 쪽 공사는 next에서 끝
					indegree[next]--;
					if (indegree[next] == 0) {
						queue.add(next);
					}
				}
			}

			System.out.println(sums[w]);
		}
	}
}
