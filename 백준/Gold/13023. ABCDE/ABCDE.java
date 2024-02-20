import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		friends = new ArrayList<>();

		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			int b = Integer.parseInt(st.nextToken());

			friends.get(a).add(b);

			friends.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(friends, i, 0);
			visited[i] = false;
		}

		System.out.println(0);
	}

	private static void dfs(ArrayList<ArrayList<Integer>> friends, int start, int count) {
		if (count == 4) {
			System.out.println(1);
			System.exit(0);
		}
		for (int i = 0; i < friends.get(start).size(); i++) {
			int num = friends.get(start).get(i);
			if (!visited[num]) {
				visited[num] = true;
				dfs(friends, num, count + 1);
				visited[num] = false;
			}
		}

	}
}
