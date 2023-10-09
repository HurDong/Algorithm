
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Main {
	static int count = 0;
	static int n;
	static int m;
	static ArrayList<Integer> com[];
	static int[] ans;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		com = new ArrayList[n + 1];
		ans = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			com[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			com[a].add(b);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}

		int large = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++)
			large = Math.max(large, ans[i]);

		for (int i = 1; i <= n; i++) {
			if (ans[i] == large) {
				System.out.print(i + " ");
			}
		}

	}

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		visited[idx] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i : com[now]) {
				if (visited[i] == false) {
					visited[i] = true;
					ans[i]++;
					queue.add(i);
				}
			}

		}

	}

}
