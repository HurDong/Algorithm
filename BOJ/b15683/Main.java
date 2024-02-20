package b15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> cctv;

	static int[][] board;

	static int[] dx = { -1, 1, 0, 0 };

	static int[] dy = { 0, 0, -1, 1 };

	static int N, M, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		// CCTV를 담을 배열
		cctv = new ArrayList<>();

		// 0 : 빈 칸 , 6 : 벽, 1~5 : CCTV
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				// CCTV 라면 cctv 배열에 좌표 추가
				if (num >= 1 && num <= 5) {
					cctv.add(new int[] { i, j, num });
				}
				// 벽이라면 board를 -1로 넣어 CCTV while문의 종료 조건으로 활용
				else if (num == 6) {
					board[i][j] = -1;
				}
			}
		}
		// CCTV 배열의 첫 인덱스부터 DFS 시작
		dfs(0);

		System.out.println(answer);
	}

	// cctv 배열을 index로 순차적으로 접근하여 완전 탐색을 실시한다.
	private static void dfs(int index) {
		if (index == cctv.size()) {
			answer = Math.min(answer, chkSize());
			return;
		}

		int x = cctv.get(index)[0];

		int y = cctv.get(index)[1];

		int type = cctv.get(index)[2];

		// CCTV가 있을 경우 번호에 따른 처리
		switch (type) {
		case 1:
			// 4방향에 대하여 실시
			for (int i = 0; i < 4; i++) {
				int a = x;
				int b = y;
				// 원상복구를 위한 배열
				ArrayList<int[]> recover = new ArrayList<>();
				// 벽을 만나거나 범위를 벗어날 때
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i];
					b += dy[i];
				}
				dfs(index + 1);
				for (int[] arr : recover) {
					board[arr[0]][arr[1]]--;
				}
			}
			break;
		case 2:
			// 2방향(상하, 좌우)에 대하여 실시
			for (int i = 0; i < 2; i++) {
				// 원상복구를 위한 배열
				ArrayList<int[]> recover = new ArrayList<>();
				// 벽을 만나거나 범위를 벗어날 때
				int a = x;
				int b = y;
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i * 2];
					b += dy[i * 2];
				}
				a = x;
				b = y;
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i * 2 + 1];
					b += dy[i * 2 + 1];
				}
				dfs(index + 1);
				for (int[] arr : recover) {
					board[arr[0]][arr[1]]--;
				}
			}
			break;
		case 3:
			// 4방향(상좌,상우,하좌,하우)에 대하여 실시
			for (int i = 0; i < 4; i++) {
				int a = x;
				int b = y;
				// 원상복구를 위한 배열
				ArrayList<int[]> recover = new ArrayList<>();
				// 벽을 만나거나 범위를 벗어날 때
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i];
					b += dy[i];
				}
				a = x;
				b = y;
				int dir = 0;
				if (i == 0) {
					dir = 3;
				} else if (i == 1) {
					dir = 2;
				} else if (i == 2) {
					dir = 0;
				} else {
					dir = 1;
				}
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[dir];
					b += dy[dir];
				}
				dfs(index + 1);
				for (int[] arr : recover) {
					board[arr[0]][arr[1]]--;
				}
			}
			break;
		case 4:
			// 4방향(좌상우,좌하우,상좌하,상우하)에 대하여 실시
			for (int i = 0; i < 4; i++) {
				int a = x;
				int b = y;
				// 원상복구를 위한 배열
				ArrayList<int[]> recover = new ArrayList<>();
				// 벽을 만나거나 범위를 벗어날 때
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i];
					b += dy[i];
				}
				a = x;
				b = y;
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[(i + 1) % 4];
					b += dy[(i + 1) % 4];
				}
				a = x;
				b = y;

				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[(i + 2) % 4];
					b += dy[(i + 2) % 4];
				}
				dfs(index + 1);
				for (int[] arr : recover) {
					board[arr[0]][arr[1]]--;
				}
			}
			break;
		case 5:
			// 원상복구를 위한 배열
			ArrayList<int[]> recover = new ArrayList<>();
			// 1방향에 대하여 실시
			for (int i = 0; i < 4; i++) {
				int a = x;
				int b = y;
				// 벽을 만나거나 범위를 벗어날 때
				while (isRange(a, b) && board[a][b] != -1) {
					board[a][b]++;
					recover.add(new int[] { a, b });
					a += dx[i];
					b += dy[i];
				}

			}
			dfs(index + 1);
			for (int[] arr : recover) {
				board[arr[0]][arr[1]]--;
			}
			break;
		default:
			break;
		}
	}

	// board의 범위를 넘어가는 지 확인한다.
	private static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M) {
			return true;
		} else
			return false;
	}

	// 전체 배열을 순회하며 사각 지대를 계산한다.
	private static int chkSize() {
		int size = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					size++;
				}
			}
		}
		return size;
	}
}
