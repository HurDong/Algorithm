package b1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// A 지원자가 어떤 B 지원자보다 두 부문에서 성적이 떨어지면 탈락
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			// members[i][0] : 서류 성적 순위 / members[i][1] : 면접 성적 순위
			int[][] members = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				members[i][0] = Integer.parseInt(st.nextToken());
				members[i][1] = Integer.parseInt(st.nextToken());
			}

			// 서류 순위 오름차순 정렬 -> 면접 순위를 비교하여 자기보다 높은 사람 나오면 선발
			Arrays.sort(members, (a, b) -> {
				return a[0] - b[0];
			});

			int count = 1; // 서류 1등은 무조건 선발

			int curM = members[0][1]; // 현재 면접 순위 -> 서류 1등으로 먼저 초기화

			for (int i = 1; i < n; i++) {
				if (curM > members[i][1]) {
					count++;
					curM = members[i][1];
				}
			}
			System.out.println(count);
		}
	}
}
