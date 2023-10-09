
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(st.nextToken());

		while (input > 0) {
			findPrime(input + 1, input * 2);
			st = new StringTokenizer(br.readLine());
			input = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
	}

	private static void findPrime(int start, int end) {
		boolean[] isPrime = new boolean[end + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= end; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= end; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = start; i <= end; i++) {
			if (isPrime[i]) {
				count++;
			}
		}

		sb.append(count + "\n");
	}
}
