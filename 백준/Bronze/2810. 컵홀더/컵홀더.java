import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		br.readLine();

		String s = br.readLine();

		int holder = 1; // 좌측

		for (int i = 0; i < s.length(); i++) {
			// 싱글
			if (s.charAt(i) == 'S') {
				holder++;
			}
			// 커플
			else {
				holder++;
				i++;
			}
		}
		System.out.println(Math.min(s.length(), holder));
	}
}
