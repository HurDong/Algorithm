package b3190;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static Deque<int[]> queue = new LinkedList<>(); // 뱀 배열 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		// 벽 : 0 (만나면 종료) / 길 : 1 / 사과 : 2(먹으면 꼬리가 그자리 + 2->1로 변경)
		int[][] board = new int[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				board[i][j] = 1;
			}
		}

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			board[sc.nextInt()][sc.nextInt()] = 2;
		}
		int answer = 0;

		// 초기 위치 (1,1)이고 오른쪽을 향함
		int[] snake = new int[3];
		snake[0] = 1;
		snake[1] = 1;
		snake[2] = 3; // 0 : 상 / 1 : 하 / 2 : 좌 / 3 : 우
		queue.addFirst(new int[] { 1, 1 });
		int l = sc.nextInt();
		while (l-- > 0) {
			int t = sc.nextInt();
			char d = sc.next().charAt(0);
			while (answer < t) {
				answer++;
				// snake[2] 방향으로 t만큼 직진
				int[] cur = queue.peekFirst();

				int x = cur[0] + dx[snake[2]];
				int y = cur[1] + dy[snake[2]];

				if (meetBody(x, y) || isWall(x, y)) {
					System.out.println(answer);
					return;
				}

				queue.addFirst(new int[] { x, y });

				// 사과를 먹으면 머리만 늘리고 1로 바꾼다.
				if (board[x][y] == 2) {
					board[x][y] = 1;
					// 1이면 꼬리를 자른다.
				} else {
					queue.removeLast();
				}
			}
			if (snake[2] == 0) {
				if (d == 'L')
					snake[2] = 2;
				else
					snake[2] = 3;
			} else if (snake[2] == 1) {
				if (d == 'L')
					snake[2] = 3;
				else
					snake[2] = 2;
			} else if (snake[2] == 2) {
				if (d == 'L')
					snake[2] = 1;
				else
					snake[2] = 0;
			} else if (snake[2] == 3) {
				if (d == 'L')
					snake[2] = 0;
				else
					snake[2] = 1;
			}
		}
		// 방향 지시 끝나면 마지막 방향으로 쭈우욱 간다.
		int[] cur = queue.peekFirst();

		int x = cur[0];
		int y = cur[1];

		while (true) {
			answer++;
			x += dx[snake[2]];
			y += dy[snake[2]];
			if (isWall(x, y) || meetBody(x, y)) {
				break;
			}

			queue.addFirst(new int[] { x, y });

			if (board[x][y] == 2) {
				board[x][y] = 1;
			} else {
				queue.removeLast();
			}
		}
		System.out.println(answer);
	}

	private static boolean isWall(int x, int y) {
		if (x <= 0 || x > n || y <= 0 || y > n) {
			return true;
		}
		return false;
	}

	// 몸통 만나면 true -> 게임 종료
	private static boolean meetBody(int x, int y) {
		for (int[] arr : queue) {
			if (x == arr[0] && y == arr[1]) {
				return true;
			}
		}
		return false;
	}

	static void print(int[][] board, int[] cur) {
		for (int i = 0; i <= n + 1; i++) {
			for (int j = 0; j <= n + 1; j++) {
				// if (cur[0] == i && cur[1] == j) {
				// System.out.print("3 ");
				// } else
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] s : queue) {
			System.out.println(s[0] + " " + s[1]);
		}
	}
}
