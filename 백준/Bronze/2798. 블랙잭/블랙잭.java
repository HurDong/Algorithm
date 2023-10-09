
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] card = new int[n];

		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();

		}

		int sum = 0;

		int idx = 0;

		int large = 0;

		while (true) {
			for (int i = idx + 1; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (j == i)
						continue;
					sum = card[idx] + card[i] + card[j];
					if (sum > large && sum <= m) {
						large = sum;
					}
				}
			}
			idx++;
			if (idx == n - 2)
				break;
		}
		System.out.println(large);
	}
}
