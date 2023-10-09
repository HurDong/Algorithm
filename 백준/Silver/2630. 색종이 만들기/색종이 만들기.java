

import java.util.Scanner;

public class Main {
	static int[][] paper;
	static int white =0;
	static int blue =0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		cutPaper(0, 0, n);
		System.out.println(white + "\n" + blue);
	}

	public static void cutPaper(int row, int col, int size) {
		if (check(row, col, size)) {
			if (paper[row][col] == 0)
				white++;
			else
				blue++;
			return;
		}

		int newSize = size / 2;

		cutPaper(row, col, newSize);
		cutPaper(row, col + newSize, newSize);
		cutPaper(row + newSize, col, newSize);
		cutPaper(row + newSize, col + newSize, newSize);

	}

	public static boolean check(int row, int col, int size) {
		int color = paper[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (paper[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
