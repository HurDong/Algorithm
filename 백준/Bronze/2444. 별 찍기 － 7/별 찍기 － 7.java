
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n - 1; i++) {
			int k = n - i;
			int l = n + i;
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (k < j && j < l) {
					System.out.print("*");
				} else {
					if (j >= l) {
						break;
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

		for (int i = 0; i < 2 * n - 1; i++) {
			System.out.print("*");
		}
		System.out.println();

		for (int i = n - 1; i >= 1; i--) {
			int k = n - i;
			int l = n + i;
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (k < j && j < l) {
					System.out.print("*");
				} else {
					if (j >= l) {
						break;
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
