
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		boolean success = false;
		if (n == 1) {

		} else {
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					n = n / i;
					System.out.println(i);
					success = true;
					i--;
				} else
					success = false;
			}
		}

	}
}