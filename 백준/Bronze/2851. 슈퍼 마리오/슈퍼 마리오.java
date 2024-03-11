import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mushrooms = new int[10];

		mushrooms[0] = Integer.parseInt(br.readLine());

		int score = mushrooms[0];

		if (score >= 100) {
			System.out.println(score);
			return;
		}

		for (int i = 1; i < 10; i++) {
			mushrooms[i] = Integer.parseInt(br.readLine());
			score += mushrooms[i];
			if (score >= 100) {
				if (Math.abs(score - 100) <= Math.abs((score - mushrooms[i]) - 100)) {
					System.out.println(score);
					return;
				} else {
					System.out.println(score - mushrooms[i]);
					return;
				}
			}
		}
		System.out.println(score);
	}
}
