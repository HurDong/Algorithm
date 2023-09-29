package b1010;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] bridge = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			bridge[i][0] = Integer.parseInt(st.nextToken());
			bridge[i][1] = Integer.parseInt(st.nextToken());

			findBridge(bridge[i][0], bridge[i][1]);
		}

	}

	private static void findBridge(int n, int m) {
		long result = 1;
		for (int i = 0; i < n; i++) {
			result = result * (m - i) / (i + 1);
		}
		System.out.println(result);
	}

}

