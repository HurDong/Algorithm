import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int answer = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>(); // 스택을 이용해서 문자를 저장하고 tail과 짝지어진다면\
			if (s.length() % 2 == 1)
				continue;
			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				// stack에 문자가 남아있으면
				if (!stack.isEmpty()) {
					// tail에 있는 문자와 같으면
					if (stack.peek() == ch) {
						// 짝지어지므로 pop
						stack.pop();
					}
					// 다르다면 일단 stack에 쌓는다 교차하지만 않으면 되므로 진행
					else {
						stack.add(ch);
					}
				}
				// 스택이 비어있으면 문자열을 add
				else {
					stack.add(ch);
				}
			}
			// 스택이 비어있어야 좋은 단어다.
			if (stack.isEmpty()) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
