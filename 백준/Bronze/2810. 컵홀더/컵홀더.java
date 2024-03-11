import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String s = sc.next();

		int holder = 1; // 좌측

		for (int i = 0; i < n; i++) {
			// 싱글
			if (s.charAt(i) == 'S') {
				holder++;
			}
			// 커플
			else {
				holder++;
				i++;
			}
		}
		System.out.println(Math.min(n, holder));

	}
}
