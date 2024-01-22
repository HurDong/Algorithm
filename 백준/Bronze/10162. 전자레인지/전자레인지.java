import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 300 60 10
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] counts = new int[3];
		while (n >= 300) {
			n -= 300;
			counts[0]++;
		}
		while (n >= 60) {
			n -= 60;
			counts[1]++;
		}
		while (n >= 10) {
			n -= 10;
			counts[2]++;
		}
		if (n > 0) {
			System.out.println("-1");
		} else {
			System.out.println(counts[0] + " " + counts[1] + " " + counts[2]);
		}
	}
}
