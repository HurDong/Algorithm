import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int n, m;

	public static void main(String[] args) throws IOException {
		// 모든 점에 대하여 사이클 완성 시 게임 종료
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 이미 부모가 같은 경우 해당 start,end를 연결 시 사이클이 발생
			if (find(parents[start]) == find(parents[end])) {
				System.out.println(i + 1);
				return;
			}
			union(start, end);
		}

		System.out.println(0);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parents[y] = x;
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

}
