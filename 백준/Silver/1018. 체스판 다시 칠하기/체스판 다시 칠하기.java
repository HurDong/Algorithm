
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		String[] line = new String[n];

		char[][] chess = new char[n][m];

		for (int i = 0; i < n; i++) {
			line[i] = sc.next();
			for (int j = 0; j < m; j++) {
				chess[i][j] = line[i].charAt(j);
			}
		}

		int x = 0;

		int y = 0;

		char[][] target = new char[8][8];

		int count = Integer.MAX_VALUE;

		while (true) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					target[i][j] = chess[i + y][j + x];
				}
			}
			for (int i = 0; i < 2; i++) {
				char[][] st = new char[8][8];
				char[] init = new char[2];
				int countSt = 0;
				if (i == 0) {
					init[0] = 'B';
					init[1] = 'W';
				} else {
					init[0] = 'W';
					init[1] = 'B';

				}
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 8; k++) {
						if (j % 2 == 0 && k % 2 == 0) {
							st[k][j] = init[0];
						} else if (j % 2 == 0 && k % 2 == 1) {
							st[k][j] = init[1];
						} else if (j % 2 == 1 && k % 2 == 0) {
							st[k][j] = init[1];
						} else if (j % 2 == 1 && k % 2 == 1) {
							st[k][j] = init[0];
						}
					}
				}
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 8; k++) {
						if (st[k][j] != target[k][j])
							countSt++;
					}
				}
				if (count > countSt)
					count = countSt;
			}
			if (x == m - 8) {
				if (y < n - 8) {
					x = 0;
					y++;

				} else
					break;
			} else
				x++;

		}
		System.out.println(count);

	}
}
