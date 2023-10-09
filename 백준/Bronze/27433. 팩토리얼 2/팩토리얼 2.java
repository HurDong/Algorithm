import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		System.out.println(fact(n));
	}

	private static long fact(long n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return fact(n - 1) * n;
		}
	}
}
