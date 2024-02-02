package b10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char[][] color;
	static char[][] rcolor;
	static boolean[][] visited;
	static boolean[][] rvisited;
	static int area;
	static int rarea;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		color = new char[n][n];
		visited = new boolean[n][n];
		rcolor = new char[n][n];
		rvisited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				color[i][j] = s.charAt(j);
				if (color[i][j] == 'R' || color[i][j] == 'G') {
					rcolor[i][j] = 'W';
				} else {
					rcolor[i][j] = 'B';
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, color[i][j]);
					area++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!rvisited[i][j]) {
					rbfs(i, j, rcolor[i][j]);
					rarea++;
				}
			}
		}
		System.out.println(area + " " + rarea);
	}

	private static void bfs(int x, int y, char col) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (visited[nx][ny])
					continue;
				if (color[nx][ny] == col) {
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static void rbfs(int x, int y, char col) {
		rvisited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (rvisited[nx][ny])
					continue;
				if (rcolor[nx][ny] == col) {
					queue.add(new int[] { nx, ny });
					rvisited[nx][ny] = true;
				}
			}
		}
	}
}
