package b2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		int holder = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'S')
				holder++;
			else {
				holder++;
				i++;
			}
		}
		System.out.println(Math.min(s.length(), holder));
	}
}
