import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int ins = Integer.parseInt(st.nextToken());
			switch (ins) {
			case 1:
				int num = Integer.parseInt(st.nextToken());
				stack.add(num);
				break;
			case 2:
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
				break;
			case 3:
				sb.append(stack.size() + "\n");
				break;
			case 4:
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case 5:
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
				break;

			}
		}
		System.out.println(sb.toString());
	}
}
