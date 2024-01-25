import java.util.Scanner;

public class Main {
	static int n;
	static int answer = 2;

	public static void main(String[] args) {
		// 상 하 좌 우로 이동
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		play2048(board, 0);

		System.out.println(answer);
	}

	private static void play2048(int[][] board, int count) {
		if (count == 5) {
			answer = Math.max(findMax(board), answer);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int[][] newBoard = move(board, i);
			play2048(newBoard, count + 1);
		}
	}

	private static int[][] move(int[][] board, int dir) {
		// 방향에 따라 어디서부터 move하는지 고려
		int[][] newBoard = new int[n][n];
		boolean[][] combined = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		// 위로 위 블럭부터 우선순위
		if (dir == 0) {
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int idx = i;
					// 먼저 0 블록의 최대한 위로
					if (newBoard[idx][j] != 0) {
						while (idx > 0 && newBoard[idx - 1][j] == 0) {
							newBoard[idx - 1][j] = newBoard[idx][j];
							newBoard[idx][j] = 0;
							idx--;
						}
						// 0이 아닌 블록을 만났을 때 합칠 수 있으면 합침
						if (idx > 0 && newBoard[idx - 1][j] == newBoard[idx][j] && !combined[idx - 1][j]) {
							newBoard[idx - 1][j] += newBoard[idx][j];
							newBoard[idx][j] = 0;
							combined[idx - 1][j] = true;
						}
					}
				}
			}
		}
		// 아래로
		else if (dir == 1) {
			for (int i = n - 2; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					int idx = i;
					// 먼저 0 블록의 최대한 아래로
					if (newBoard[idx][j] != 0) {
						while (idx < n - 1 && newBoard[idx + 1][j] == 0) {
							newBoard[idx + 1][j] = newBoard[idx][j];
							newBoard[idx][j] = 0;
							idx++;
						}
						// 0이 아닌 블록을 만났을 때 합칠 수 있으면 합침
						if (idx < n - 1 && newBoard[idx + 1][j] == newBoard[idx][j] && !combined[idx + 1][j]) {
							newBoard[idx + 1][j] += newBoard[idx][j];
							newBoard[idx][j] = 0;
							combined[idx + 1][j] = true;
						}
					}
				}
			}
		}
		// 왼쪽으로
		else if (dir == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {
					int idx = j;
					// 먼저 0 블록의 최대한 왼쪽으로
					if (newBoard[i][idx] != 0) {
						while (idx > 0 && newBoard[i][idx - 1] == 0) {
							newBoard[i][idx - 1] = newBoard[i][idx];
							newBoard[i][idx] = 0;
							idx--;
						}
						// 0이 아닌 블록을 만났을 때 합칠 수 있으면 합침
						if (idx > 0 && newBoard[i][idx - 1] == newBoard[i][idx] && !combined[i][idx - 1]) {
							newBoard[i][idx - 1] += newBoard[i][idx];
							newBoard[i][idx] = 0;
							combined[i][idx - 1] = true;
						}
					}
				}
			}
		}
		// 오른쪽으로
		else {
			for (int i = 0; i < n; i++) {
				for (int j = n - 2; j >= 0; j--) {
					int idx = j;
					// 먼저 0 블록의 최대한 오른쪽으로
					if (newBoard[i][idx] != 0) {
						while (idx < n - 1 && newBoard[i][idx + 1] == 0) {
							newBoard[i][idx + 1] = newBoard[i][idx];
							newBoard[i][idx] = 0;
							idx++;
						}
						// 0이 아닌 블록을 만났을 때 합칠 수 있으면 합침
						if (idx < n - 1 && newBoard[i][idx + 1] == newBoard[i][idx] && !combined[i][idx + 1]) {
							newBoard[i][idx + 1] += newBoard[i][idx];
							newBoard[i][idx] = 0;
							combined[i][idx + 1] = true;
						}
					}
				}
			}
		}

		return newBoard;
	}

	private static int findMax(int[][] board) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, board[i][j]);
//				System.out.print(board[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println();
		return max;
	}
}
