
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		System.out.println(fact(n) / (fact(n - k) * fact(k)));
	}

	private static long fact(long n) {
		long result = 1;
		for (long i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

}
