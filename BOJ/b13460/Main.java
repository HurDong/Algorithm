package b13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ox, oy;
	static char[][] board;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];

		int rx = 0, ry = 0, bx = 0, by = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'R') {
					board[i][j] = '.';
					rx = i;
					ry = j;
				} else if (board[i][j] == 'B') {
					board[i][j] = '.';
					bx = i;
					by = j;
				} else if (board[i][j] == 'O') {
					ox = i;
					oy = j;
				}
			}
		}

		dfs(bx, by, rx, ry, 0);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void dfs(int bx, int by, int rx, int ry, int count) {
		/*
		 * 케이스 : (b와 r이 같은 칸에 있을 경우는 무조건 늦게 들어온 구슬을 전 칸으로) 1. b 벽에 막혔을 때 1. r 벽에 막혔을 때 :
		 * 모두 전 칸으로 2. r 벽에 안 막혔을 때 : b만 전 칸으로 2. b 벽에 안 막혔을 때 1. r 벽에 막혔을 때 : r만 전 칸으로
		 * 2. r 벽에 안 막혔을 때 1. b이 구멍에 들어 갔을 때 1. r이 구멍에 들어 갔을 때 : 실패 2. r이 구멍에 안 들어 갔을 때
		 * : 실패 2. b이 구멍에 안 들어 갔을 때 1. r이 구멍에 들어 갔을 때 : 성공 2. r이 구멍에 안 들어 갔을 때 : 모두 다음 칸
		 */
		if (count > 10) {
			return;
		}

		if (board[bx][by] == 'O') {
			return;
		}

		if (board[rx][ry] == 'O') {
			answer = Math.min(answer, count);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int bnx = bx;

			int bny = by;

			int rnx = rx;

			int rny = ry;

			// 파란 구슬 이동
			while (board[bnx + dx[i]][bny + dy[i]] != '#') {
				bnx += dx[i];

				bny += dy[i];

				if (board[bnx][bny] == 'O') {
					break;
				}
			}

			// 빨간 구슬 이동
			while (board[rnx + dx[i]][rny + dy[i]] != '#') {
				rnx += dx[i];

				rny += dy[i];

				if (board[rnx][rny] == 'O') {
					break;
				}
			}

			// 벽에 부딪히거나 구멍으로 갔을 때 루프들이 끝난다.
			// 루프들이 끝난 후 빨간 구슬과 파란 구슬이 같은 곳에서 멈출 경우
			// 위치의 재조정이 필요하다.
			if (bnx == rnx && bny == rny && board[bnx][bny] != 'O') {
				// 빨간 파란 구슬 모두 구멍에 들어가면 실패
				int bDist = Math.abs(bnx - bx) + Math.abs(bny - by);
				int rDist = Math.abs(rnx - rx) + Math.abs(rny - ry);

				// 애초에 거리가 같은 경우는 없음
				if (rDist > bDist) {
					rnx -= dx[i];
					rny -= dy[i];
				} else {
					bnx -= dx[i];
					bny -= dy[i];
				}
			}
			dfs(bnx, bny, rnx, rny, count + 1);
		}
		return;
	}
}
