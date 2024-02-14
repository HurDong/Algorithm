package b2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 예산 상한액을 만들어 예산 분배
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long[] budgets = new long[n];

		long sum = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			budgets[i] = Long.parseLong(st.nextToken());
			sum += budgets[i];
		}

		Arrays.sort(budgets);

		long m = Long.parseLong(br.readLine());

		// 예산 내로 모두 분배 가능한 경우 최댓값 출력 후 return
		if (m >= sum) {
			System.out.println(budgets[n - 1]);
			return;
		}

		// 아닌 경우 평균 이하의 분배 가능한 예산은 분배 후 남은 예산을 나머지 지방에 분배
		int limit = 0;

		for (int i = 0; i < n; i++) {
			// 예산에서 분배 못할 경우 인덱스 저장
			if (budgets[i] * (n - i) < m) {
				m -= budgets[i];
			}
			// 예산에서 분배
			else {
				limit = (int) (m / (n - i));
				break;
			}
		}

		System.out.println(limit);
	}
}
