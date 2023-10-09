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

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[m + 1];

		Deque<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int i = 1; i <= m; i++) {
			int idx = 1;
			// queue에서 arr[i]값과 같은 것을 찾으면 해당 idx를 반환
			for (int target : queue) {
				if (target == arr[i]) {
					break;
				}
				idx++;
			}
			// idx가 1 과 queue.size() 사이에서 어디에 가까운지 알아내기
			// 1 2 3 4 5 6 7 8
			// 중간 이하
			if ((queue.size() / 2) + 1 >= idx) {
				for (int j = 0; j < idx - 1; j++) {
					queue.addLast(queue.pollFirst());
					count++;
				}
				queue.pollFirst();
			}
			// 중간 이상
			else {
				for (int k = 0; k < queue.size() - idx + 1; k++) {
					queue.addFirst(queue.pollLast());
					count++;
				}
				queue.pollFirst();
			}

		}
		System.out.println(count);

	}
}
