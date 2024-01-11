import java.util.Scanner;

public class Main {
	static final long MOD = 1000000007;

	public static void main(String[] args) {
		// 페르마의 소정리 : a가 정수이고, p가 소수 일 때 gcd(a,p) = 1 이면
		// a^(p-1) = 1(mod p) 이다. -> a^-1 = a^(p-2) (mod p)
		// 임의의 소수 X 에 대하여 b의 모듈러 곱셈에 대한 역원은 b^(X-2)이다.
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		long answer = 0;
		for (int i = 0; i < m; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			answer = (answer + modExecute(b, a)) % MOD;
		}
		System.out.println(answer);
	}

	private static long modExecute(long a, long b) {
		long gcdNum = gcd(a, b);
		a /= gcdNum;
		b /= gcdNum;
		return (long) a % MOD * pow(b, MOD - 2) % MOD;
	}

	private static long pow(long a, long b) {
		if (b == 1)
			return a;
		long rest = pow(a, b / 2);
		rest = rest * rest % MOD;
		return b % 2 != 0 ? rest * a % MOD : rest;
	}

	private static long gcd(long a, long b) {
		if (a < b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
// 보충 학습 必