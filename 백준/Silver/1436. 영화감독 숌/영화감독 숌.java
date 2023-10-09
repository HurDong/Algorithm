
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int num = 0;

		int count = 0;

		while (count < n) {
			num++;
			if (Integer.toString(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}
