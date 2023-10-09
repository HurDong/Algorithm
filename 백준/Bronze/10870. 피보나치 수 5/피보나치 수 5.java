import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		System.out.println(fivo(n));
	}

	private static long fivo(long n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fivo(n - 1) + fivo(n - 2);
		}
	}
}
