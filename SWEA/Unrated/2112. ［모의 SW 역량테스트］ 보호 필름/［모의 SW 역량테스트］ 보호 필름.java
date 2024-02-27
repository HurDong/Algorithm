import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int answer, d, w, k;

	static int[][] board;

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			d = Integer.parseInt(st.nextToken());

			w = Integer.parseInt(st.nextToken());

			k = Integer.parseInt(st.nextToken());

			board = new int[d][w];

			answer = k;

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0, board);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int depth, int count, int[][] arr) {
		// 답보다 크면 답이 될 수 없으므로 return
		if (count >= answer)
			return;
		//
		if (depth == d) {
			if (chkBoard(arr)) {
				answer = Math.min(answer, count);
			}
			return;
		}

		// 현재 행 약품처리 X
		dfs(depth + 1, count, arr);

		// 현재 행에 A 약품 처리
		int[][] newArrA = changeBoard(arr, depth, 0);
		dfs(depth + 1, count + 1, newArrA);

		// 현재 행에 B 약품 처리
		int[][] newArrB = changeBoard(arr, depth, 1);
		dfs(depth + 1, count + 1, newArrB);
	}

	private static boolean chkBoard(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			int count = 1;
			for (int row = 1; row < arr.length; row++) {
				// 이전 행과 현재 행이 같은 경우, count 증가
				if (arr[row][col] == arr[row - 1][col]) {
					count++;
					// count가 k 이상이면 해당 열은 통과
					if (count >= k)
						break;
				} else {
					// 다르면 count를 1로 초기화 후 순회
					count = 1;
				}
			}
			// 반복문 후 count < k 이면 조건 만족 X
			if (count < k)
				return false;
		}
		return true;
	}

	private static int[][] changeBoard(int[][] arr, int h, int num) {
		// temp를 arr의 얕은 복사 진행
		int[][] temp = new int[d][];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i].clone();
		}
		for (int i = 0; i < w; i++) {
			temp[h][i] = num;
		}
		return temp;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}