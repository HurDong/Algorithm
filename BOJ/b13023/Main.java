package b13023;

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

		// 각자 ArrayList<>()에 서로를 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			int b = Integer.parseInt(st.nextToken());

			friends.get(a).add(b);

			friends.get(b).add(a);
		}

		// DFS를 돌며 5명이 문제의 조건을 만족하는 경우가 생기는 지 확인
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(friends, i, 0);
			visited[i] = false;
		}

		// System.exit(0)을 기저 조건 실행문에 넣었으므로 이 부분에 오는 경우 0을 출력
		System.out.println(0);
	}

	private static void dfs(ArrayList<ArrayList<Integer>> friends, int start, int count) {
		// 문제의 조건에 맞을 때 1을 출력 후 System.exit(0)
		if (count == 4) {
			System.out.println(1);
			System.exit(0);
		}
		// 이전 dfs의 start에 친구에 대하여 방문하지 않은 친구를 방문
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
