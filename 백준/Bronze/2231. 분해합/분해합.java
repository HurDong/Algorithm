
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int idx = 0;
		for (int i = 1; i < n; i++) {
			int temp = i;
			int log = (int) Math.log10(n);
			int[] logArr = new int[log + 1];
			for (int j = log; j > 0; j--) {
				logArr[j] = (int) (temp / Math.pow(10, j));
				temp = (int) (temp - logArr[j] * Math.pow(10, j));
			}
			logArr[0] = i % 10;

			int sum = i;

			for (int k = 0; k < log + 1; k++) {
				sum = sum + logArr[k];
			}
			if (n == sum) {
				idx = i;
				break;
			}
		}
		System.out.println(idx);
	}
}
