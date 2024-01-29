import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 메모리 초과가 발생하여 에라토스의 체말고 백트래킹(dfs)로 도전
		dfs("", n);
		System.out.println(sb.toString());
	}

	private static void dfs(String s, int n) {
		if (s.length() == n) {
			if (isPrime(s)) {
				sb.append(s+"\n");
			}
			return;
		}

		// n 보다 길이가 작을 때 부분 수가 소수가 아닐경우 return
		if (!s.isEmpty() && !isPrime(s)) {
			return;
		}

		for (int i = 0; i <= 9; i++) {
			// s 뒤에 i를 추가
			dfs(s + i, n);
		}

	}

	private static boolean isPrime(String s) {
		int num = Integer.parseInt(s);
		if (num < 2)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		// 홀수에 대하여 소수인지 판별
		for (int i = 3; i < num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
