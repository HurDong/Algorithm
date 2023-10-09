
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			findLCM(A, B);
		}
	}

	private static void findLCM(int a, int b) {
		int idx = 2;
		int tempA = a;
		int tempB = b;
		while (idx <= 45000) {
			if (a % idx == 0 && b % idx == 0) {
				a = a / idx;
				b = b / idx;
			} else {
				idx++;
			}
		}
		System.out.println(a * tempB);
	}
}
