package b2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long[] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 틀렸다고 표기 -> int 범위를 넘어서 long으로 모든 변수 변경
		long T = Long.parseLong(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		a = new long[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			a[i] = a[i - 1] + Long.parseLong(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		b = new long[m + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= m; i++) {
			b[i] = b[i - 1] + Long.parseLong(st.nextToken());
		}

		// 부분합 배열 생성
		ArrayList<Long> sumA = new ArrayList<>();
		ArrayList<Long> sumB = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				sumA.add(a[j] - a[i]);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j <= m; j++) {
				sumB.add(b[j] - b[i]);
			}
		}

		// 부분합 배열 정렬 (n,m이 1000보다 작으므로 연속된 부분집합의 수 n*(n-1) / 2
		Collections.sort(sumA);
		Collections.sort(sumB);

		long count = 0;
		int pA = 0;
		int pB = sumB.size() - 1;

		while (pA < sumA.size() && pB >= 0) {
			long curA = sumA.get(pA);
			long curB = sumB.get(pB);
			long sum = curA + curB;
			if (sum == T) {
				long countA = 0;
				long countB = 0;
				// 부분합 중 curA와 같은 값인 것들을 찾는다.
				while (pA < sumA.size() && sumA.get(pA) == curA) {
					pA++;
					countA++;
				}
				// 부분합 중 curB와 같은 값인 것들을 찾는다.
				while (pB >= 0 && sumB.get(pB) == curB) {
					pB--;
					countB++;
				}
				// 두 부분합 조건에 맞는 원소들의 경우의 수를 곱하여 count를 갱신한다.
				count += countA * countB;
				// 값을 낮춘다.
			} else if (sum > T) {
				pB--;
				// 값을 올린다.
			} else {
				pA++;
			}
		}
		System.out.println(count);

	}

}
