package b1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				buildings[i] = Integer.parseInt(st.nextToken());
				graph.add(new ArrayList<>());
			}
			// n까지 해야하므로 graph 하나 더 추가
			graph.add(new ArrayList<>());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

			}
		}

	}
}
