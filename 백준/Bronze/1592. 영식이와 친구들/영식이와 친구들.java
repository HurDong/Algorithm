import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		int l = sc.nextInt();

		int[] counts = new int[n]; // 각 자리가 공을 받은 횟수

		int count = 0; // 총 공 던진 횟수

		int idx = 0; // 1번 자리부터 시작

		counts[0] = 1; // 1번 자리 공 받은 상태로 게임 시작

		while (chkCounts(counts, m)) {
			// 짝수면
			if (counts[idx] % 2 == 0) {
				idx += l;
				if (idx >= n) {
					idx -= n;
				}
			}
			// 홀수면
			else {
				idx -= l;
				if (idx < 0) {
					idx = n + idx;
				}
			}
			counts[idx]++;
			count++;
		}

		System.out.println(count);
	}

	private static boolean chkCounts(int[] counts, int m) {
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] >= m) {
				return false;
			}
		}
		return true;
	}
}
