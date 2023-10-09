
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String s = st.nextToken();

			if (s.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if (s.equals("top")) {
				if (stack.size() == 0) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
				}
			} else if (s.equals("pop")) {
				if (stack.size() == 0) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
			} else if (s.equals("size")) {
				System.out.println(stack.size());
			} else if (s.equals("empty")) {
				if (stack.size() == 0) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			}
		}

	}

}
