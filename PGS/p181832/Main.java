package PGS.p181832;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int num = 1;
		int row = 0, col = 0, nextRow = 0, nextCol = 0, direction = 0;
		// direction 0:오른쪽, 1:아래, 2:왼쪽, 3:위
		while (true) {
			arr[row][col] = num++;
			// System.out.println("( " + row + " , " + col + " ) = " + arr[row][col]);
			if (num > n * n) {
				break;
			}
			switch (direction) {
			case 0:
				nextRow = row;
				nextCol = col + 1;
				break;
			case 1:
				nextRow = row + 1;
				nextCol = col;
				break;
			case 2:
				nextRow = row;
				nextCol = col - 1;
				break;
			case 3:
				nextRow = row - 1;
				nextCol = col;
				break;
			}
			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && arr[nextRow][nextCol] == 0) {
				row = nextRow;
				col = nextCol;
			} else {
				direction = (direction + 1) % 4;
				// direction이 변경된 후에 다시 nextRow와 nextCol을 계산
				switch (direction) {
				case 0:
					nextRow = row;
					nextCol = col + 1;
					break;
				case 1:
					nextRow = row + 1;
					nextCol = col;
					break;
				case 2:
					nextRow = row;
					nextCol = col - 1;
					break;
				case 3:
					nextRow = row - 1;
					nextCol = col;
					break;
				}
				// 다시 검사 후에 row와 col 업데이트
				if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && arr[nextRow][nextCol] == 0) {
					row = nextRow;
					col = nextCol;
				}
			}

		}
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				if (j < arr[i].length - 1) {
					System.out.print(", ");
				}
			}
			if (i == arr.length - 1) {
				System.out.print("]");
			} else {
				System.out.print("], ");
			}
		}
		System.out.println("]");
	}
}
