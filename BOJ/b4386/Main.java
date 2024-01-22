package b4386;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static class Star implements Comparable<Star> {
		int start;
		int end;
		double dist;

		public Star(int start, int end, double dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		double[][] stars = new double[n][n];

		for (int i = 0; i < n; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}

		// 모든 별이 간접적으로 이어져 있어야 한다.
		ArrayList<Star> graph = new ArrayList<>();

		// 모든 정점을 간선으로 먼저 잇는다.
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double dist = calcDist(stars[i], stars[j]);
				graph.add(new Star(i, j, dist));
			}
		}

		// dist의 길이 오름차순으로 정렬
		Collections.sort(graph);

		double answer = 0;
		
		// 거리가 짧은 간선부터 시작 -> 거리가 긴 간선은 union으로 인해 포함되지 않을 확률 높음.
		for (Star star : graph) {
			int s1 = find(star.start);
			int s2 = find(star.end);
			if (s1 != s2) {
				union(s1, s2);
				answer += star.dist;
			}
		}

		// 소수 두번째 자리까지 표현
		System.out.printf("%.2f\n", answer);
	}

	private static double calcDist(double[] s1, double[] s2) {
		double dist = 0;

		double x = Math.abs(s1[0] - s2[0]);
		double y = Math.abs(s1[1] - s2[1]);

		x = Math.pow(x, 2);
		y = Math.pow(y, 2);

		dist = Math.sqrt(x + y);

		return dist;
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		// 최소 비용이므로 작은 놈을 부모로 갖자.
		if (x < y) {
			parents[y] = x;
		} else if (x > y) {
			parents[x] = y;
		}

	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}
}
