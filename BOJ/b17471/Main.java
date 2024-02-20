package b17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, sum = 0, answer = Integer.MAX_VALUE;
	static int[] pop;
	static ArrayList<ArrayList<Integer>> areas;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		pop = new int[N + 1]; // 지역당 인구수

		sum = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			sum += pop[i];
		}

		areas = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			areas.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());

			for (int j = 0; j < m; j++) {
				areas.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		// N개의 지역을 두 선거구로 나눴을 때 선거구의 인구수 차이 최소화 문제, 선거구 안의 구역끼리 연결되어 있어야함.
		for (int i = 1; i <= 5; i++) {
			// left의 길이는 i
			int[] arr = new int[i];
			boolean[] visited = new boolean[N + 1];
			divide(0, 1, i, arr, visited);
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void divide(int depth, int start, int size, int[] arr, boolean[] visited) {
		if (depth == size) {
			// 1~N 숫자 저장
			Set<Integer> set = new HashSet<>();

			for (int i = 1; i <= N; i++) {
				set.add(i);
			}

			// 두가지의 그룹으로 나눠졌는 지 확인하기 위해 set에서 arr원소들 제거
			for (int i = 0; i < size; i++) {
				set.remove(arr[i]);
			}

			// list에 arr 아닌 수만 남았다.
//			if (chkSet(set)) {
			int arrSum = 0;
			for (int num : arr) {
				arrSum += pop[num];
				System.out.print(num + " ");
			}
			System.out.println(answer);
			answer = Math.min(answer, Math.abs((sum - arrSum) - arrSum));
//			}

			return;
		}

		for (int i = start; i <= N; i++) {
			if (depth == 0) {
				arr[depth] = i;
//				visited[i] = true;
				divide(depth + 1, i + 1, size, arr, visited);
			} else {
				if (areas.get(arr[depth - 1]).contains(i)) {
//					&& !visited[i]) {
					arr[depth] = i;
					visited[i] = true;
					divide(depth + 1, i + 1, size, arr, visited);
				}
			}
		}
	}

	private static boolean chkSet(Set<Integer> set) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] notVisited = new boolean[N + 1];
		for (int num : set) {
			queue.add(num);
			notVisited[num] = true;
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int num : areas.get(cur)) {
				if (notVisited[num]) {
					notVisited[num] = false;
					queue.add(num);
				}
			}
		}
		for (boolean b : notVisited) {
			if (b)
				return false;
		}
		return true;
	}
}
