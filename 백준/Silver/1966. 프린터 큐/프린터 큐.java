import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			int m = Integer.parseInt(st.nextToken());

			int idx = m;

			int count = 0;

			st = new StringTokenizer(br.readLine());

			Queue<Integer> print = new LinkedList<Integer>();

			// print queue에 입력받은 값들 넣기.
			for (int j = 0; j < n; j++) {
				print.offer(Integer.parseInt(st.nextToken()));
			}
			while (!print.isEmpty()) {
				int large = Collections.max(print);
				if (print.peek() == large) {
					print.poll();
					count++;
					if (idx == 0) {
						idx = -1;
						sb.append(count + "\n");
						break;
					}
					idx--;
				} else {
					print.offer(print.poll());
					if (idx == 0) {
						idx = print.size() - 1;
					} else {
						idx--;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
