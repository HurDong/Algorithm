
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Integer.parseInt(st.nextToken());

		long B = Integer.parseInt(st.nextToken());

		findGCD(A, B);
	}

	private static void findGCD(long a, long b) {
		long idx = 2;
		long tempA = a;
		long tempB = b;
		long result = 1;
		while (idx <= a || idx <= b) {
			if (a % idx == 0 && b % idx == 0) {
				a = a / idx;
				b = b / idx;
				result = result * idx;
			} else {
				idx++;
			}
		}
		System.out.println((tempA / result) * tempB);
	}
}
