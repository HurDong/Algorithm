
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		String s;

		Queue<Integer> queue = new LinkedList<Integer>();

		int back = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			switch (s) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				back = num;
				break;
			case "pop":
				if (!queue.isEmpty()) {
					sb.append(queue.poll() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				if (!queue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append("1\n");
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					sb.append(queue.peek() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					sb.append(back + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
