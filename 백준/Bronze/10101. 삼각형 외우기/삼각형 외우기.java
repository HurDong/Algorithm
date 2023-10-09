
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n3 = Integer.parseInt(st.nextToken());

		if (n1 == n2 && n1 == n3 && n2 == n3 && n1 + n2 + n3 == 180)
			System.out.println("Equilateral");
		else {
			if (n1 == n2 && n2 != n3 && n1 + n2 + n3 == 180) {
				System.out.println("Isosceles");
			} else if (n1 == n3 && n1 != n2 && n1 + n2 + n3 == 180) {
				System.out.println("Isosceles");
			} else if (n2 == n3 && n1 != n2 && n1 + n2 + n3 == 180) {
				System.out.println("Isosceles");
			} else if (n1 != n2 && n1 != n3 && n2 != n3 && n1 + n2 + n3 == 180) {
				System.out.println("Scalene");
			} else {
				System.out.println("Error");
			}
		}

	}
}