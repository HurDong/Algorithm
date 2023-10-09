
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			findPrime(n);
		}
	}

	// 18 = 5 + 13 = 7 + 11
	//
	// 36 = 5 + 31 = 7 + 29 = 13 + 23 = 17 + 19
	private static void findPrime(int num) {
		boolean[] isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= num; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= num; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i <= num / 2; i++) {
			if (isPrime[i]) {
				if (isPrime[num - i]) {
					count++;
				}

			}
		}
		System.out.println(count);
	}
}
