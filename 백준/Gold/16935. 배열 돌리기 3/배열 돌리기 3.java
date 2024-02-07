import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int r = Integer.parseInt(st.nextToken()); // 회전 수

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] types = new int[r];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < r; i++) {
			types[i] = Integer.parseInt(st.nextToken());
		}

		rotate(board, n, m, 0, types);
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[][] rotate(int[][] arr, int n, int m, int count, int[] types) {
		if (count == types.length) {
			print(arr);
			System.exit(0);
		}

		int[][] rBoard;

		int[][] board1;

		int[][] board2;

		int[][] board3;

		int[][] board4;

		switch (types[count]) {
		// 상하 반전
		case 1:
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < m; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[(n - 1) - i][j];
					arr[(n - 1) - i][j] = temp;
				}
			}
			rotate(arr, n, m, count + 1, types);
			break;
		// 좌우 반전
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m / 2; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[i][(m - 1) - j];
					arr[i][(m - 1) - j] = temp;
				}
			}
			rotate(arr, n, m, count + 1, types);
			break;
		// 오른쪽 90도 회전
		case 3:
			rBoard = new int[m][n];
			for (int idx = 0; idx < (n < m ? n / 2 : m / 2); idx++) {
				for (int i = idx; i < n - idx * 2; i++) {
					for (int j = idx; j < m - idx * 2; j++) {
						rBoard[j][(n - 1) - i] = arr[i][j];
					}
				}
			}
			rotate(rBoard, m, n, count + 1, types);
			break;
		// 왼쪽 90도 회전
		case 4:
			rBoard = new int[m][n];
			for (int idx = 0; idx < (n < m ? n / 2 : m / 2); idx++) {
				for (int i = idx; i < n - idx * 2; i++) {
					for (int j = idx; j < m - idx * 2; j++) {
						rBoard[(m - 1) - j][i] = arr[i][j];
					}
				}
			}
			rotate(rBoard, m, n, count + 1, types);
			break;
		// 4그룹으로 나눈 후 시계 방향 회전
		case 5:
			board1 = new int[n / 2][m / 2];
			board2 = new int[n / 2][m / 2];
			board3 = new int[n / 2][m / 2];
			board4 = new int[n / 2][m / 2];

			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < m / 2; j++) {
					board1[i][j] = arr[i][j];
					board2[i][j] = arr[i][(m / 2) + j];
					board3[i][j] = arr[(n / 2) + i][(m / 2) + j];
					board4[i][j] = arr[(n / 2) + i][j];
				}
			}
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < m / 2; j++) {
					arr[i][j] = board4[i][j];
					arr[i + (n / 2)][j] = board3[i][j];
					arr[i][j + (m / 2)] = board1[i][j];
					arr[i + (n / 2)][j + (m / 2)] = board2[i][j];
				}
			}
			rotate(arr, n, m, count + 1, types);
			break;
		// 4그룹으로 나눈 후 반시계 방향 회전
		case 6:
			board1 = new int[n / 2][m / 2];
			board2 = new int[n / 2][m / 2];
			board3 = new int[n / 2][m / 2];
			board4 = new int[n / 2][m / 2];
			
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < m / 2; j++) {
					board1[i][j] = arr[i][j];
					board2[i][j] = arr[i][(m / 2) + j];
					board3[i][j] = arr[(n / 2) + i][(m / 2) + j];
					board4[i][j] = arr[(n / 2) + i][j];
				}
			}
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < m / 2; j++) {
					arr[i][j] = board2[i][j];
					arr[i + (n / 2)][j] = board1[i][j];
					arr[i][j + (m / 2)] = board3[i][j];
					arr[i + (n / 2)][j + (m / 2)] = board4[i][j];
				}
			}
			rotate(arr, n, m, count + 1, types);
			break;
		}
		return arr;
	}
}