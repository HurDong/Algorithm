import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, count;
	static int[] students;
	static boolean[] visited;
	static boolean[] finished; // 더 이상 탐색 안해도 되는 학생
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 사이클이 존재할 때 한팀
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			count = 0;

			students = new int[n + 1];

			visited = new boolean[n + 1];

			finished = new boolean[n + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}

			// 1번 학생부터 시작해 사이클 존재 확인
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					// 사이클 확인을 위해 현재 학생은 visited 처리하지않음
					dfs(i);
				}
			}
			sb.append(n - count + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int target) {
		if (visited[target]) {
			return;
		}
		visited[target] = true;
		// 희망 학생이 방문되지 않았을 경우
		if (!visited[students[target]]) {
			// dfs 실시
			dfs(students[target]);
		} else {
			// 방문을 했지만, dfs 미완료인 학생일 경우
			if (!finished[students[target]]) {
				// target은 팀이 있으므로 count 증가
				count++;
				int temp = students[target];
				// target와 같은 팀원들 수만큼 count 증가
				while (temp != target) {
					temp = students[temp];
					count++;
				}
			}
		}
		// dfs 완료
		finished[target] = true;
	}
}
