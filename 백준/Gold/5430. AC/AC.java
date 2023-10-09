import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			String arr = st.nextToken();

			arr = arr.replace("[", "").replace("]", "");

			int[] num = new int[n];

			String[] temp = new String[n];

			temp = arr.split(",");

			Deque<Integer> queue = new LinkedList<Integer>();

			for (int j = 0; j < n; j++) {
				num[j] = Integer.parseInt(temp[j]);
				queue.add(num[j]);
			}

			boolean isError = false;

			boolean isReversed = false;

			for (int k = 0; k < s.length(); k++) {
				switch (s.charAt(k)) {
				case 'R':
					if (isReversed) {
						isReversed = false;
					} else {
						isReversed = true;
					}
					break;
				case 'D':
					if (!queue.isEmpty()) {
						if (isReversed) {
							queue.removeLast();
						} else {
							queue.removeFirst();
						}
					} else {
						isError = true;
					}
					break;
				default:
					break;
				}
			}
			if (isError) {
				sb.append("error\n");
			} else {
				if (isReversed) {
					sb.append("[");
					while (!queue.isEmpty()) {
						sb.append(queue.removeLast());
						if (!queue.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				} else {
					sb.append("[");
					while (!queue.isEmpty()) {
						sb.append(queue.removeFirst());
						if (!queue.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
