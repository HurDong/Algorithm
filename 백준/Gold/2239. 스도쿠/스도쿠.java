import java.util.Scanner;

public class Main {
	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			String s = sc.next();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = s.charAt(j) - '0';
			}
		}
		draw(0, 0);

	}

	private static void draw(int x, int y) {
		if (x == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		} else {
			if (sudoku[x][y] == 0) {
				for (int i = 1; i <= 9; i++) {
					if (isValid(x, y, i)) {
						sudoku[x][y] = i;
						// y값이 9가 되면 0으로 만들고 x를 1증가
						if (y + 1 == 9) {
							draw(x + 1, 0);
						} else {
							draw(x, y + 1);
						}
						sudoku[x][y] = 0;
					}
				}
			} else {
				// 값 있으면 스킵
				if (y + 1 == 9) {
					draw(x + 1, 0);
				} else {
					draw(x, y + 1);
				}
			}
		}
	}

	private static boolean isValid(int x, int y, int idx) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == idx || sudoku[x][i] == idx
					|| sudoku[(x / 3) * 3 + (i / 3)][(y / 3) * 3 + i % 3] == idx) {
				return false;
			}
		}
		return true;
	}
}
