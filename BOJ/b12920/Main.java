package b12920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Item {
		int v, c;

		public Item(int v, int c) {
			this.v = v;
			this.c = c;
		}

	}

	static final int INF = 10000 * 100 + 1;

	public static void main(String[] args) throws IOException {
		// 기존 배낭 문제 + 같은 물건 여러개일 수도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<int[]> items = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 비트마스킹을 이용해 이진수로 items에 데이터 나누어서 저장
			for (int k = 1; c > 0; k *= 2) {
				int num = Math.min(k, c);
				c -= num;
				items.add(new int[] { num * a, num * b });
			}
		}

		// dp[i][j] : i번째 물건까지 사용했을 때 j 무게일 때의 최대 만족도
		int[][] dp = new int[items.size()][m + 1];

		// items[0] : 무게 / items[1] : 만족도
		for (int i = 0; i < m + 1; i++) {
			if (items.get(0)[0] <= i) {
				dp[0][i] = items.get(0)[1];
			}
		}
		
		// 여기까지는 잘 들어감

		for (int i = 1; i < items.size(); i++) {
			for (int j = 0; j < m + 1; j++) {
				if (j - items.get(i)[0] >= 0) {
					// j 무게를 맞췄을 때 최대 만족도 return
					dp[i][j] = Math.max(dp[i - 1][j - items.get(i)[0]] + items.get(i)[1], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[items.size() - 1][m]);
	}
}
