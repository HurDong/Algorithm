package b12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String t = br.readLine();

		int n = s.length();

		int m = t.length();

		int p1 = 0;

		int p2 = t.length() - 1;

		boolean c = true; // true : 오른쪽에서 왼쪽 , false : 왼쪽에서 오른쪽

		for (int i = 0; i < m - n; i++) {
			if (c) {
				if (t.charAt(p2) == 'B')
					c = false; // B면 뒤집기
				p2--;
			} else {
				if (t.charAt(p1) == 'B')
					c = true; // B면 뒤집기
				p1++;
			}
		}
		// 정방향 : p1 -> p2
		if (c) {
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) != t.charAt(p1 + i)) {
					System.out.println(0);
					return;
				}
			}
		}
		// 역방향 : p1 <- p2
		else {
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) != t.charAt(p2 - i)) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
	}
}
