
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];

		int large = 0;
		int largeIdx = 0;
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > large) {
				large = arr[i];
				largeIdx = i;
			}
		}

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			if (i == largeIdx) {

			} else {
				sum = sum + arr[i];
			}
		}
		if (sum <= large)
			System.out.println(sum + sum - 1);
		else {
			int ans=0;
			for(int i=0;i<3;i++) {
				ans=ans+arr[i];
			}
			System.out.println(ans);
		}

	}
}