
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());

		int end = Integer.parseInt(st.nextToken());

		findPrime(start, end);
	}

	private static void findPrime(int start, int end) {
		BigInteger b = BigInteger.valueOf(start);
		int bNum = b.intValue();
		while (bNum <= end) {
			if (b.isProbablePrime(10)) { // b가 소수면 true
				System.out.println(b);
			}
			bNum++;
			b = BigInteger.valueOf(bNum);
		}
	}
}
