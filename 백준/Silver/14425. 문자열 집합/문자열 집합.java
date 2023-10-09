
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n의 범위는 1~500000

		int m = sc.nextInt(); // m의 범위는 1~500000

		Set<String> st = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st.add(sc.next());
		}

		String[] target = new String[m];

		StringBuilder sb = new StringBuilder();

		int count = 0;

		for (int i = 0; i < m; i++) {
			target[i] = sc.next(); // target[i]의 범위는 -10000000~10000000
			if (st.contains(target[i])) {
				count++;
			}
		}
		System.out.println(count);

	}
}
