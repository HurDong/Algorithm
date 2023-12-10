import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // 괄호를 찾으면 닫히기전까지 괄호를 찾는다.
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    // (를 만날때까지 pop
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                // 연산자일 경우
                case '+':
                case '-':
                case '*':
                case '/':
                    // 우선순위 검사 후 스택에 있는 것보다 우선순위가 낮을 시 스택을 pop하고 해당 연산자를 스택에 넣는다.
                    while (!stack.isEmpty() && prioriotyCheck(stack.peek()) >= prioriotyCheck(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                // 알파벳일 경우
                default:
                    sb.append(c);
                    break;
            }
        }
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    private static int prioriotyCheck(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '(' || ch == ')') {
            return 0;
        }
        return -1;
    }
}
