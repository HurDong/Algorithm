
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n의 범위는 1~500000

		int[] card = new int[n];

		Set<Integer> st = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt(); // card[i]의 범위는 -10000000~10000000
			st.add(card[i]);
		}

		int m = sc.nextInt(); // m의 범위는 1~500000

		int[] target = new int[m];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			target[i] = sc.nextInt(); // target[i]의 범위는 -10000000~10000000
			if (st.contains(target[i])) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb.toString());

	}
}
