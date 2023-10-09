
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> card = new HashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (card.containsKey(input)) {
				card.replace(input, card.get(input), card.get(input) + 1);
			} else {
				card.put(input, 1);
			}
		}

		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (card.containsKey(target)) {
				sb.append(card.get(target) + " ");
			} else {
				sb.append("0 ");
			}
		}

		System.out.println(sb.toString());
	}
}
