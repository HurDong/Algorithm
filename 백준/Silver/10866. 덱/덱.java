import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<Integer> dq = new LinkedList<>();

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			int num;
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
				break;
			case "pop_front":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollFirst() + "\n");
				}
				break;
			case "pop_back":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollLast() + "\n");
				}
				break;
			case "size":
				sb.append(dq.size() + "\n");
				break;
			case "empty":
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekFirst() + "\n");
				}
				break;
			case "back":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekLast() + "\n");
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
