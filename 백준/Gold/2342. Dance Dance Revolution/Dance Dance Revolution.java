import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 제자리 : 1 / 중앙칸 : 2
		// 인접칸 : 3 / 반대칸 : 4
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> command = new ArrayList<>();

		int com = -1;

		command.add(0); // 초기 시작 위치 0

		while (true) {
			int num = sc.nextInt();
			if (num == 0)
				break;
			command.add(num);

		}

		int size = command.size();

		// dp[i][j][k] : i번째 시행할 때 왼발이 j에 오른발이 k에 있을 때의 최소 힘
		int[][][] dp = new int[size][5][5];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					dp[i][j][k] = 987654321;
				}
			}
		}

		dp[0][0][0] = 0;

		for (int i = 0; i < size - 1; i++) {
			int target = command.get(i + 1);
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (target != j) {
						dp[i + 1][j][target] = Math.min(dp[i + 1][j][target], dp[i][j][k] + calcDiff(k, target));
					}
					if (target != k) {
						dp[i + 1][target][k] = Math.min(dp[i + 1][target][k], dp[i][j][k] + calcDiff(j, target));
					}
				}
			}
		}
		findMin(dp[size - 1]);
	}

	private static void findMin(int[][] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
				}
			}
		}
		System.out.println(min);

	}

	private static int calcDiff(int x, int y) {
		if (x == 0) {
			return 2;
		} else if (Math.abs(x - y) == 2) {
			return 4;
		} else if (x - y == 0) {
			return 1;
		} else {
			return 3;
		}
	}
}
