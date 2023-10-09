
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		// ax + by = c
		// dx + ey = f
		// eax + bey = ec
		// bdx + bey = bf
		// x = (ec-bf) / (ea-bd)
		// y = (dc-af)/(db-ae)
		System.out.println(((e * c - b * f) / (e * a - b * d)) + " " + ((d * c - a * f) / (d * b - a * e)));
	}
}
