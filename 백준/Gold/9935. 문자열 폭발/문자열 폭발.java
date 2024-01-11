import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		String bomb = sc.next();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
			// 스택이 폭탄만큼 쌓일 경우 체크
			if (stack.size() >= bomb.length()) {
				boolean isBomb = true; // 스택이 연속적으로 폭탄을 포함하는 경우
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				if (isBomb) { // 폭탄이 있는 경우 바로 삭제
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		for (char c : stack) {
			sb.append(c);
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}
	}
}
