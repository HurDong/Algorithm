import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		// 카드 묶음을 저장하면서 합친 카드 묶음을 다시 넣어 최소 연산 계산
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			queue.add(Integer.parseInt(st.nextToken()));
		}

		long answer = 0;

		// 묶음이 하나면 비교 연산할 필요없으므로 return
		if (n == 1) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			int num1 = queue.poll();
			if (queue.isEmpty()) {
				break;
			}
			int num2 = queue.poll();
			// 정답에 비교 연산 더해주기.
			answer += num1;
			answer += num2;
			queue.add(num1 + num2);
		}
		System.out.println(answer);
	}
}
