import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] indegree = new int[n + 1];

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int prev = sc.nextInt(); // 이전 우선순위를 기억하여 해당 graph 에 추가한다.
			for (int j = 1; j < k; j++) {
				int num = sc.nextInt();
				graph.get(prev).add(num);
				indegree[num]++;
				prev = num;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + "\n");
			count++;
			for (int next : graph.get(cur)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		// 우선순위를 못 정할경우 0 출력
		if (count != n) {
			System.out.println(0);
		} else {
			System.out.println(sb.toString());
		}
	}
}
