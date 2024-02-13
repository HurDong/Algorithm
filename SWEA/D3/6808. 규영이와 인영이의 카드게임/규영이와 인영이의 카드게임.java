import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] gCard, iCard;
	static int gWin, gLose;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 362880
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			gCard = new int[9];

			iCard = new int[9];

			gWin = 0;

			gLose = 0;

			visited = new boolean[9];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 9; i++) {
				gCard[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(gCard);

			int[] nums = new int[19];

			for (int i = 1; i <= 18; i++) {
				nums[i] = i;
			}

			for (int i = 0; i < 9; i++) {
				nums[gCard[i]] = 0;
			}

			int idx = 0;

			for (int i = 1; i <= 18; i++) {
				if (nums[i] > 0) {
					iCard[idx++] = i;
				}
			}
			boolean[] visited = new boolean[9];
			int[] gQ = new int[9];

			// 규영이의 카드만 조합으로 순서를 바꿔 정렬된 인영이의 카드와 비교한다.
			cardGame(0, gQ, visited);

			sb.append("#" + tc + " " + gWin + " " + gLose + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void cardGame(int idx, int[] gQ, boolean[] visited) {
		if (idx == 9) {
			int gScore = 0;
			int iScore = 0;
			// gQ에는 Combination으로 모든 가능한 경우의 수가 되어 있음 이를 iCard와 비교
			for (int i = 0; i < 9; i++) {
				if (gQ[i] > iCard[i]) {
					gScore += gQ[i] + iCard[i];
				} else if (gQ[i] < iCard[i]) {
					iScore += gQ[i] + iCard[i];
				}
			}
			if (gScore > iScore) {
				gWin++;
			} else {
				gLose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				gQ[idx] = gCard[i];
				visited[i] = true;
				cardGame(idx + 1, gQ, visited);
				visited[i] = false;
			}
		}
	}
}
