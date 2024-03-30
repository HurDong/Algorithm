package b1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int answer, n, w, h;

	static int[][] board;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			w = Integer.parseInt(st.nextToken());

			h = Integer.parseInt(st.nextToken());

			answer = w * h;

			board = new int[h][w];

			int blocks = 0;

			for (int i = 0; i < h; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {

					board[i][j] = Integer.parseInt(st.nextToken());
					// 전체 블럭의 갯수를 구한다.
					if (board[i][j] > 0) {
						blocks++;
					}
				}
			}

			// step 1 : 완전 탐색을 통해 0~w-1까지 구슬 놓기
			// step 2 : 숫자만큼 벽돌을 부수고 재귀를 돌며
			// step 3 : count가 n이 되면 남은 벽돌의 수를 구함.(계산을 때려야할지 파라미터로 넘겨야할지)
			int[] comb = new int[n];

			makePerm(comb, 0, blocks);

			sb.append("#" + tc + " " + answer + "\n");
		}

		System.out.println(sb.toString());

	}

//	1
//	3 10 10
//	0 0 0 0 0 0 0 0 0 0
//	1 0 1 0 1 0 0 0 0 0
//	1 0 3 0 1 1 0 0 0 1
//	1 1 1 0 1 2 0 0 0 9
//	1 1 4 0 1 1 0 0 1 1
//	1 1 4 1 1 1 2 1 1 1
//	1 1 5 1 1 1 1 2 1 1
//	1 1 6 1 1 1 1 1 2 1
//	1 1 1 1 1 1 1 1 1 5
//	1 1 7 1 1 1 1 1 1 1
	private static void makePerm(int[] comb, int count, int blocks) {
		if (count == n) {

//			print(board);

			answer = Math.min(answer, blocks);

			return;
		}

		for (int i = 0; i < w; i++) {

			boolean isBlock = false;

			int height = 0;

			for (int j = 0; j < h; j++) {

				if (board[j][i] > 0) {

					isBlock = true;

					height = j;
				}
			}

			if (isBlock) {
				int[][] temp = new int[h][w];

				// 깊은 복사로 원상 복구할 temp를 저장
				for (int j = 0; j < h; j++) {
					for (int k = 0; k < w; k++) {
						temp[j][k] = board[j][k];
					}
				}

				int blockDif = breakBlocks(height, i);

				// 떠 있는 블럭을 아래로 내림
				for (int j = 0; j < h - 1; j++) {
					for (int k = 0; k < w; k++) {
						if (board[j][k] > 0) {
							goDown(j, k);
						}
					}
				}

				comb[count] = i;
				if (comb[0] == 2) {
					for (int l = 0; l < n; l++) {
						System.out.print(comb[l] + " ");
					}
					System.out.println();
					print(board);
				}
				makePerm(comb, count + 1, blocks - blockDif);
				// 완전 탐색으로 정해진 (height,i) 좌표의 블럭을 삭제하면서 연관된 블럭들도 삭제
				// blocks - blockDif);
				board = temp;
			}
		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void goDown(int x, int y) {
		while (true) {
			if (x == h - 1) {
				break;
			}
			// x>0
			if (board[x + 1][y] > 0) {
				break;
			}

			board[x + 1][y] = board[x][y];

			board[x][y] = 0;
		}
	}

	private static int breakBlocks(int x, int y) {
		int range = board[x][y];

		board[x][y] = 0;

		int blocks = 1;

		for (int i = 1; i < range; i++) {

			if (isRange(x, y + i) && board[x][y + i] > 0) {
				blocks += breakBlocks(x, y + i);
			}

			if (isRange(x, y - i) && board[x][y - i] > 0) {
				blocks += breakBlocks(x, y - i);
			}

			if (isRange(x + i, y) && board[x + i][y] > 0) {
				blocks += breakBlocks(x + i, y);
			}

			if (isRange(x - i, y) && board[x - i][y] > 0) {
				blocks += breakBlocks(x - i, y);
			}
		}

		return blocks;
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < h && y < w;

	}
}
