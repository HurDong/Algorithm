
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			checkPrime(arr[i]);
		}
		System.out.println(count);
	}

	private static void checkPrime(int num) {
		int chkCount = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				chkCount++;
		}
		if (chkCount == 2)
			count++;
	}
}