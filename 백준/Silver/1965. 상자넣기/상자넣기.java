import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] boxes = new int[n];

		for (int i = 0; i < n; i++) {
			boxes[i] = sc.nextInt();
		}

		// dp[i] : 인덱스 0부터 i까지 최장길이
		int[] dp = new int[n];

		dp[0] = 1;

		int max = 1; // 최댓값 저장

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (boxes[i] > boxes[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
