import java.util.Scanner;

public class Main {
	static int N;
	static int[] population;
	static boolean[][] adj;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		population = new int[N];
		adj = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			population[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int count = sc.nextInt();
			for (int j = 0; j < count; j++) {
				int to = sc.nextInt() - 1;
				adj[i][to] = true;
				adj[to][i] = true; // 양방향 연결
			}
		}

		for (int i = 1; i < (1 << N) - 1; i++) {
			if (isValid(i)) {
				answer = Math.min(answer, getDiff(i));
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static boolean isValid(int set) {
		boolean[] visited = new boolean[N];
		int start1 = -1, start2 = -1;

		for (int i = 0; i < N; i++) {
			if ((set & (1 << i)) != 0) {
				if (start1 == -1)
					start1 = i;
			} else {
				if (start2 == -1)
					start2 = i;
			}
		}

		dfs(start1, set, visited);
		dfs(start2, ~set, visited);

		for (boolean b : visited) {
			if (!b)
				return false;
		}
		return true;
	}

	static void dfs(int start, int set, boolean[] visited) {
		if (visited[start] || (set & (1 << start)) == 0)
			return;
		visited[start] = true;
		for (int i = 0; i < N; i++) {
			if (adj[start][i]) {
				dfs(i, set, visited);
			}
		}
	}

	static int getDiff(int set) {
		int population1 = 0, population2 = 0;
		for (int i = 0; i < N; i++) {
			if ((set & (1 << i)) != 0) {
				population1 += population[i];
			} else {
				population2 += population[i];
			}
		}
		return Math.abs(population1 - population2);
	}
}
