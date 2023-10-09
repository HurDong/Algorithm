import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();

			Stack<Character> bracket = new Stack<Character>();

			if (s.charAt(0) == '.') {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					bracket.push('(');
				}
				if (s.charAt(i) == '[') {
					bracket.push('[');
				}
				if (s.charAt(i) == ')') {
					if (bracket.isEmpty()) {
						bracket.push(')');
						break;
					} else if (bracket.peek() == '(') {
						bracket.pop();
					} else {
						bracket.push(')');
						break;
					}
				}
				if (s.charAt(i) == ']') {
					if (bracket.isEmpty()) {
						bracket.push(']');
						break;
					} else if (bracket.peek() == '[') {
						bracket.pop();
					} else {
						bracket.push(']');
						break;
					}
				}

			}
			if (bracket.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
	}
}
