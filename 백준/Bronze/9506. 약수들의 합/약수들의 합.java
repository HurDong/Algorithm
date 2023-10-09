
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 0;
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == -1)
				break;
			checkPerfect(n);

		}
	}

	private static void checkPerfect(int n) {
		int[] arr = new int[n];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				arr[count] = i;
				count++;
			}
		}
		

		int sum = 0;
		for (int i = 0; i < count - 1 ; i++) {
			sum = sum + arr[i];
		}

		if (sum == n) {
			System.out.print(n + " = ");
			for (int i = 0; i < count-1; i++) {
				if (i == 0)
					System.out.print(arr[i]);
				else {
					System.out.print(" + " + arr[i]);
				}
			}
			System.out.println();
		} else {
			System.out.println(n + " is NOT perfect.");
		}
	}
}