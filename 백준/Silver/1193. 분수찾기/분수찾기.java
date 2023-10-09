
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());

		long[] pow = new long[10000];

		pow[1] = 1;

		for (int i = 2; i < 10000; i++) {
			pow[i] = pow[i - 1] + (i - 1);
		}

		// 1 / 2 3 / 4 5 6 / 7 8 9 10 // 1 2 4 7 11

		long check;
		long div;
		if (n == 1) {
			System.out.println("1/1");
		} else {
			for (int i = 1; i < 10000; i++) {
				if (pow[i] > n) {
					check = n % pow[i - 1];
					div = n / pow[i - 1];
					// i%2 ==1 인 경우는 낮은게 분자가 크다.
					if (i % 2 == 1) {
						System.out.println((div + check) + "/" + (i - div - check));
					} else { // i%2==0 인 경우는 낮은게 분모가 크다.
						System.out.println((i - div - check) + "/" + (div + check));
					}
					break;
				}
			}
		}

	}
}