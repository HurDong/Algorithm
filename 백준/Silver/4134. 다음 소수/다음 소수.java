
import java.io.*;
import java.math.BigInteger;
import java.util.*;

//1000000000
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		long n = 0;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Long.parseLong(st.nextToken());
			BigInteger b = BigInteger.valueOf(n);
			findPrime(b);
		}

	}

	private static void findPrime(BigInteger b) {

		if(b.isProbablePrime(10)) {
			System.out.println(b);
		}
		else {
			System.out.println(b.nextProbablePrime());
		}

	}
}
