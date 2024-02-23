import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans = 0;
	static int[][] players;
	static int[] perm;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		// 1~n이닝에서 1~9번 선수의 결과
		players = new int[n][9];

		perm = new int[9];

		visited = new boolean[9];

		// 1번 선수는 4번 타자
		visited[0] = true;
		perm[3] = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(0);

		System.out.println(ans);
	}

	private static void permutation(int depth) {
		if (depth == 9) {
			calcScore();
			return;
		} else if (depth == 3) {
			permutation(depth + 1);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					perm[depth] = i;
					permutation(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	private static int calcScore() {
		// 현재 이닝
		int innings = 0;
		// 현재 타자 번호
		int idx = 0;
		// 현재 아웃 카운트
		int outs = 0;
		// 현재 점수
		int score = 0;
		while (innings < n) {
			// base[0] : 1루 base[1] : 2루 base[2] : 3루
			int[] bases = new int[3];
			while (outs < 3) {
				int run = players[innings][perm[idx]];
				// base 증가를 임시 저장할 배열
				if (run == 0)
					outs++;
				else {
					for (int i = 2; i >= Math.max(3 - run, 0); i--) {
						if (bases[i] == 1)
							score++;
					}
					for (int i = 2; i >= 0; i--) {
						bases[i] = (i - run >= 0 ? bases[i - run] : 0);
					}
					if (run == 4)
						score++;
					else
						bases[run - 1] = 1;
				}

				idx++;

				if (idx == 9) {
					idx = 0;
				}
			}
			outs = 0;
			innings++;
		}
		// 현재 이닝이 n이닝이 될 때까지
		if (ans < score) {
			ans = score;
		}
		return score;
	}

}
