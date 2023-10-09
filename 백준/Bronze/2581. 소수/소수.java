
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int min = n;
		int sum = 0;

		for (int i = m; i <= n; i++) {
			int count = 0;
			for (int k = 1; k <= i; k++) {
				if (i % k == 0) {
					count++;
				}
			}
			if (count == 2) {
				if (min > i)
					min = i;
				sum = sum + i;
			}
		}
		if (sum == 0)
			System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}