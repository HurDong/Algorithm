

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Integer.parseInt(st.nextToken());

		// 1 / 2~7 / 8~19 / 20~37 / 38~61
		// 1 / 6 / 12 / 18 / 24
		// 1 2 8 20 38 -> Sn = Sn-1 + 6(n-2) (n>=3)

		long ans = 0;
		if (n == 1)
			ans = 1;
		if (n == 2)
			ans = 2;

		long temp = 2;
		int count =1;
		if (n > 2) {
			count = 2;
			for (int i = 0; i < n; i++) {
				if (n < temp) {
					break;
				} else
					count++;
				temp = temp + 6 * (i + 1);
			}
			count--;
		}

		if (count >= 2)
			ans = count;
		System.out.println(ans);

	}
}