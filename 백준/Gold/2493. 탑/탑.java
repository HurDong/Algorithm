import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 높이를 저장하는 Stack
		Stack<Integer> towers = new Stack<>();

		// 인덱스를 저장하는 Stack
		Stack<Integer> idxStack = new Stack<>();

		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
//			System.out.println(towers);

			// 비교값
			int tower = Integer.parseInt(st.nextToken());

			// 스택이 비어 있으면 0을 저장
			if (towers.isEmpty()) {
				answer[i] = 0;
				towers.push(tower);
				idxStack.push(1);
			}

			// 비어 있지 않으면
			else {
				while (!towers.isEmpty()) {
					// stack의 head가 tower보다 크거나 같은 경우 레이저 신호 수신 가능
					if (towers.peek() >= tower) {
						break;
					}
					// stack의 head가 tower보다 작은 경우 stack의 다음 원소를 참조
					else {
						towers.pop();
						idxStack.pop();
					}
				}
				if (!towers.isEmpty()) {
					answer[i] = idxStack.peek();
					towers.push(tower);
					idxStack.push(i + 1);
				} else {
					answer[i] = 0;
					towers.push(tower);
					idxStack.push(i + 1);
				}
			}
		}

		for (int tower : answer) {
			sb.append(tower + " ");
		}
		System.out.println(sb.toString());
	}
}
