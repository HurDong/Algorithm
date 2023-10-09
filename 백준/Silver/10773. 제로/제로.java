
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

			int target = Integer.parseInt(st.nextToken());

			if (target == 0) {
				stack.pop();
			} else {
				stack.add(target);
			}
		}

		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum = sum + stack.get(i);
		}
		System.out.println(sum);

	}

}
