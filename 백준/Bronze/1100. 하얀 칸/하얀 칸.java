import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			if (i % 2 == 0) {
				for (int j = 0; j < 4; j++) {
					if (s.charAt(j * 2) == 'F')
						count++;
				}
			} else {
				for (int j = 0; j < 4; j++) {
					if (s.charAt(j * 2 + 1) == 'F')
						count++;
				}
			}
		}
		System.out.println(count);
	}
}
