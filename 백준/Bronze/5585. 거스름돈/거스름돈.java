import java.util.Scanner;

public class Main {
	// 620 -> 500 + 100 + 10 + 10
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		n = 1000 - n;

		int count = 0;

		while (n >= 500) {
			n -= 500;
			count++;
		}

		while (n >= 100) {
			n -= 100;
			count++;
		}

		while (n >= 50) {
			n -= 50;
			count++;
		}

		while (n >= 10) {
			n -= 10;
			count++;
		}

		while (n >= 5) {
			n -= 5;
			count++;
		}

		while (n >= 1) {
			n -= 1;
			count++;
		}
		System.out.println(count);
	}
}
