
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			int big = 0;
			int bigIdx = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i] > big) {
					big = arr[i];
					bigIdx = i;
				}
			}

			int sum = 0;
			for (int i = 0; i < 3; i++) {
				if (i == bigIdx) {

				} else {
					sum = sum + arr[i];
				}
			}

			if (arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2])
				System.out.println("Equilateral");
			else {
				if (big >= sum) {
					System.out.println("Invalid");
				} else if (arr[0] == arr[1] && arr[1] != arr[2]) {
					System.out.println("Isosceles");
				} else if (arr[0] == arr[2] && arr[0] != arr[1]) {
					System.out.println("Isosceles");
				} else if (arr[1] == arr[2] && arr[0] != arr[1]) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			}
		}

	}
}